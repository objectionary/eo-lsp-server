![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/GeorgySabaev/eo-lsp-server/build.yml?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GeorgySabaev_eo-lsp-server&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=GeorgySabaev_eo-lsp-server)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=GeorgySabaev_eo-lsp-server&metric=coverage)](https://sonarcloud.io/summary/new_code?id=GeorgySabaev_eo-lsp-server)
![GitHub](https://img.shields.io/github/license/GeorgySabaev/eo-lsp-server)

This is the LSP server for [EO](https://github.com/objectionary/eo).
It provides semantic highlighting, and parsing error checking for `.eo` files.

This plugin is written in **TypeScript**, and was developed with **Node 20**.

Inside `src/` you can find all the Typescript source code, along with tests
in `src/test/` and code parser files in `src/parser/` once they are generated.

The code parser is generated with ANTLR4 using a version of the EO grammar
file located in [this ANTLR g4 file][g4].
The specific commit to take the file from is specified in `package.json` under `.config.grammar.commit.`

## Using with Sublime Text

To use this EO LSP server with Sublime Text, you'll need to install
the [LSP package] and configure it to work with the EO language server.

First, build the EO LSP server:

```bash
git clone https://github.com/GeorgySabaev/eo-lsp-server.git
cd eo-lsp-server
npm install
npm run fetch-and-build-grammar
npm run build
npm run package
```

This will create standalone executables in the `bin/` directory:

* `server-linux` for Linux
* `server-macos` for macOS
* `server-win.exe` for Windows

### Configuring Sublime Text

1. Open Sublime Text preferences for LSP:
   - `Preferences → Package Settings → LSP → Settings`

1. Add the following configuration to the user settings:

```json
{
  "clients": {
    "eo-lsp": {
      "enabled": true,
      "command": ["/path/to/eo-lsp-server/bin/server-macos"],
      "selector": "source.eo",
      "settings": {
        "maxNumberOfProblems": 1000
      }
    }
  }
}
```

Replace `/path/to/eo-lsp-server/bin/server-macos` with the actual path
to your built server executable
(use `server-linux` on Linux or `server-win.exe` on Windows).

### EO Syntax Highlighting

For basic syntax highlighting, you'll need to create an EO syntax definition file:

1. Create a new file in Sublime Text

1. Save it as `EO.sublime-syntax` in your Sublime Text `Packages/User` directory:

* On macOS: `~/Library/Application Support/Sublime Text/Packages/User/`
* On Linux: `~/.config/sublime-text/Packages/User/`
* On Windows: `%APPDATA%\Sublime Text\Packages\User\`

3. Add the following basic syntax definition in YAML:

```yaml
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

## How to Contribute

Clone the repository.

Install node modules with:

```bash
npm install
```

Download grammar file and generate ANTLR4 parser automatically with:

```bash
npm run fetch-and-build-grammar
```

Make changes on a new branch.
You can run an instance of VS Code with the extension running by hitting `F5`
in the code editor.
After modifications, test your code with:

```bash
npm run unit-test
```

Create a pull request. To avoid frustration, run this before committing:

```bash
npm run lint
npm run build
```

[g4]: https://raw.githubusercontent.com/objectionary/eo/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4
[LSP package]: https://packagecontrol.io/packages/LSP
