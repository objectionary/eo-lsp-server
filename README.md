![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/GeorgySabaev/eo-lsp-server/build.yml?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GeorgySabaev_eo-lsp-server&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=EOLangVSCode_eo-vscode)


This is the LSP server for [EO](https://github.com/objectionary/eo). It provides semantic highlighting, and parsing error checking for your .eo files.

## Structure
This plugin is written in **TypeScript**, and was developed with **Node 20**. 

Inside `src/` you can find all the Typescript source code, along with tests in `src/test/` and code parser files in `src/parser/` once they are generated.

The code parser is generated with ANTLR4 using a version of the EO grammar file located in this [link](https://raw.githubusercontent.com/objectionary/eo/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4). The specific commit to take the file from is specified in `package.json` under `.config.grammar.commit.`

## How to Contribute
Clone the repository. 

Install node modules with:
```bash
$ npm install
```

Download grammar file and generate ANTLR4 parser automatically with:
```bash
$ npm run fetch-and-build-grammar
```

Make changes on a new branch. You can run an instance of VSCode with the extension running by hitting F5 in the code editor. After modifications, test your code with:
```bash
$ npm run unit-test
```

Create a pull request. To avoid frustration, run:
```bash
$ npm run lint
$ npm run build
```
before commiting.
