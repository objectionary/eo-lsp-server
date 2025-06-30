// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import {
    createConnection,
    TextDocuments,
    Diagnostic,
    DiagnosticSeverity,
    ProposedFeatures,
    InitializeParams,
    DidChangeConfigurationNotification,
    TextDocumentSyncKind,
    InitializeResult,
    SemanticTokensRegistrationOptions,
    SemanticTokensRegistrationType
} from "vscode-languageserver/node.js";
import { TextDocument } from "vscode-languageserver-textdocument";
import { Capabilities } from "./capabilities";
import { EoVersion } from "./eo-version";
import { SemanticTokensProvider } from "./semantics";
import { getParserErrors } from "./parser";
import { ParserError } from "./parserError";
import { DefaultSettings } from "./defaultSettings";

/**
 * Connection with the server, using Node's IPC as a transport.
 * Also includes all preview / proposed LSP features.
 */
const connection = createConnection(ProposedFeatures.all);

/**
 * Simple text document manager.
 */
const documents: TextDocuments<TextDocument> = new TextDocuments(TextDocument);

/**
 * Client capabilities manager, to define what is and is not able to do.
 */
const capabilities = new Capabilities();

/**
 * Provider of the semantic highlighting capability of the language server.
 */
let provider: SemanticTokensProvider;

/**
 * Defines procedures to be executed on the initialization process
 * of the connection with the client
 */
connection.onInitialize((params: InitializeParams) => {
    const caps = params.capabilities;
    capabilities.initialize(caps);
    provider = new SemanticTokensProvider(params.capabilities.textDocument!.semanticTokens!);
    const result: InitializeResult = {
        capabilities: {
            textDocumentSync: TextDocumentSyncKind.Incremental
        }
    };
    if (capabilities.workspace) {
        result.capabilities.workspace = {
            workspaceFolders: {
                supported: true
            }
        };
    }
    return result;
});

/**
 * Defines procedures to be executed once initialization process
 * of the connection with the client has concluded.
 *
 * Registers the following possible capabilities of the client:
 * Configuration, Workspace Folder and Document Semantic Tokens
 */
connection.onInitialized(() => {
    if (capabilities.configuration) {
        connection.client.register(DidChangeConfigurationNotification.type, void 0);
    }
    if (capabilities.workspace) {
        connection.workspace.onDidChangeWorkspaceFolders(_event => {
            connection.console.log("Workspace folder change event received");
        });
    }
    if (capabilities.tokens) {
        const options: SemanticTokensRegistrationOptions = {
            documentSelector: null,
            legend: provider.legend,
            range: false,
            full: {
                delta: true
            }
        };
        connection.client.register(SemanticTokensRegistrationType.type, options);
    }
});

/**
 * Settings of the Language Server
 */
const defaultSettings: DefaultSettings = { limit: 1000 };

/**
 * The global settings, used when the `workspace/configuration` request is not supported by the client.
 */
let settings: DefaultSettings = defaultSettings;

/**
 * Cache for the settings of all open documents
 */
const cache: Map<string, Thenable<DefaultSettings>> = new Map();

/**
 * Retrieves the settings for a document
 * @param resource - String for the scheme of the document for which to retrieve its settings
 * @returns - A Promise for the settings of the document requested
 */
function getDocumentSettings(resource: string): Thenable<DefaultSettings> {
    if (!capabilities.configuration) {
        return Promise.resolve(settings);
    }
    let result = cache.get(resource);
    if (!result) {
        result = connection.workspace.getConfiguration({
            scopeUri: resource,
            section: "languageServerExample"
        }).then(config => ((config && typeof config === "object") ? config : defaultSettings));
        cache.set(resource, result);
    }
    return result;
}

/**
 * Performs error checking for the given document through its parsing. Sends to VSCode
 * each problem returned by the parser up until the maximum number of problems defined
 * in the given document's settings.
 * @param document - Document for which to perform the validation procedure
 * @returns {Promise<void>}
 */
async function validateTextDocument(document: TextDocument): Promise<void> {
    const config = await getDocumentSettings(document.uri);
    const text = document.getText();
    const diagnostics: Diagnostic[] = [];
    const errors = getParserErrors(text);
    const effective = config || defaultSettings;
    const limit = effective.limit;
    errors.forEach((error, index) => {
        if (limit !== null && index >= limit) {
            return;
        }
        const diagnostic: Diagnostic = {
            severity: DiagnosticSeverity.Error,
            range: {
                start: { line: error.line - 1, character: error.column },
                end: { line: error.line - 1, character: error.column }
            },
            message: `${error.msg} (EO ${EoVersion})`,
            source: "ex"
        };
        diagnostics.push(diagnostic);
    });
    connection.sendDiagnostics({ uri: document.uri, diagnostics });
}

/**
 * Resets all cached document settings and revalidates all open text
 * documents with there is a change in the configuration of the client.
 */
connection.onDidChangeConfiguration(change => {
    if (capabilities.configuration) {
        cache.clear();
    } else {
        const config = change.settings.languageServerExample;
        settings = (config && typeof config === "object") ? config : defaultSettings;
    }
    documents.all().forEach(validateTextDocument);
});

/**
 * Clears the settings cache for a closed document, once it is closed
 */
documents.onDidClose(e => {
    cache.delete(e.document.uri);
});

/**
 * Performs the validation of a document once it is opened or its content is
 * modified.
 */
documents.onDidChangeContent(change => {
    validateTextDocument(change.document);
});

/**
 * Logs if a change in a watched document is detected
 */
connection.onDidChangeWatchedFiles(_change => {
    connection.console.log("We received a file change event");
});

/**
 * Performs semantic highlighting for the document defined in the
 * callback parameter once the document is first opened.
 */
connection.languages.semanticTokens.on(params => {
    const document = documents.get(params.textDocument.uri);
    if (!document) {
        return { data: [] };
    }
    return provider.provideSemanticTokens(document);
});

/**
 * Performs semantic highlighting for the document defined in the
 * callback parameter once the document is changed.
 */
connection.languages.semanticTokens.onDelta(params => {
    const document = documents.get(params.textDocument.uri);
    if (!document) {
        return { data: [] };
    }
    return provider.provideDeltas(document);
});

/**
 * Make the text document manager listen on the connection
 * for open, change and close text document events
 */
documents.listen(connection);

/**
 * Listen on the connection
 */
connection.listen();
