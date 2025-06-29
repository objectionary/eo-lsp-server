# LSP Server for EOLANG

![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/GeorgySabaev/eo-lsp-server/build.yml?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GeorgySabaev_eo-lsp-server&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=GeorgySabaev_eo-lsp-server)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=GeorgySabaev_eo-lsp-server&metric=coverage)](https://sonarcloud.io/summary/new_code?id=GeorgySabaev_eo-lsp-server)
![GitHub](https://img.shields.io/github/license/GeorgySabaev/eo-lsp-server)

This is the [LSP] server for [EO](https://github.com/objectionary/eo).
It provides semantic highlighting, and parsing error checking for `.eo` files
(written in [EOLANG]).

## Using with Sublime Text

To use this [LSP] server with [Sublime Text], you'll need to install
the [LSP package]. Then, build this server:

```bash
git clone https://github.com/objectionary/eo-lsp-server.git
cd eo-lsp-server
npm install
npm run fetch-and-build-grammar
npm run build
npm run package
```

This will create standalone executables in the `bin/` directory
(`eo-lsp-server-linux` for Linux, `eo-lsp-server-macos` for macOS,
`eo-lsp-server-win.exe` for Windows).

The, open Sublime Text preferences for LSP
(`Preferences → Package Settings → LSP → Settings`) and
add the following configuration to the user settings:

```json
{
  "clients": {
    "eo-lsp": {
      "enabled": true,
      "command": ["/path/to/eo-lsp-server/bin/eo-lsp-server-macos", "--stdio"],
      "selector": "source.eo",
      "settings": {
        "maxNumberOfProblems": 1000
      }
    }
  }
}
```

Replace `/path/to/eo-lsp-server/bin/eo-lsp-server-macos` with the actual path
to your built server executable
(use `eo-lsp-server-linux` on Linux or `eo-lsp-server-win.exe` on Windows).

Then, create an EO syntax definition file in `Packages/User/EO.sublime-syntax`:

```yaml
%YAML 1.2
---
name: EO
file_extensions:
  - eo
scope: source.eo
contexts:
  main:
    - match: '#.*$'
      scope: comment.line.eo
    - match: '\b(package|import|alias|meta|self|@|true|false)\b'
      scope: keyword.eo
    - match: '"[^"]*"'
      scope: string.quoted.double.eo
    - match: '\b\d+(\.\d+)?\b'
      scope: constant.numeric.eo
    - match: '[+\-*/=<>!&|^~?:]'
      scope: keyword.operator.eo
```

Should work. If it doesn't, [file an issue], we'll help.

## How to Contribute

Inside `src/` you can find all the Typescript source code, along with tests
in `src/test/` and code parser files in `src/parser/` once they are generated.

The code parser is generated with ANTLR4 using a version of the EO grammar
file located in [this ANTLR g4 file][g4].
The specific commit to take the file from is specified in `package.json` under `.config.grammar.commit.`

Fist, install Node modules with:

```bash
npm install
```

Then, download grammar file and generate [ANTLR4] parser automatically with:

```bash
npm run fetch-and-build-grammar
```

Make changes on a new branch.
You can run an instance of VS Code with the extension running by hitting `F5`
in the code editor.
After modifications, test your code with:

```bash
npm run test
```

Create a pull request. To avoid frustration, run this before committing:

```bash
npm run lint
npm run build
```

[g4]: https://raw.githubusercontent.com/objectionary/eo/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4
[LSP package]: https://packagecontrol.io/packages/LSP
[LSP]: https://en.wikipedia.org/wiki/Language_Server_Protocol
[EOLANG]: https://www.eolang.org
[ANTLR4]: https://github.com/antlr/antlr4
[Sublime Text]: https://www.sublimetext.com/
[file an issue]: https://github.com/objectionary/eo-lsp-server/issues
