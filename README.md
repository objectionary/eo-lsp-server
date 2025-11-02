# LSP Server for EOLANG

![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/objectionary/eo-lsp-server/make.yml?branch=master)
![GitHub](https://img.shields.io/github/license/objectionary/eo-lsp-server)
[![codecov](https://codecov.io/gh/objectionary/eo-lsp-server/branch/master/graph/badge.svg)](https://codecov.io/gh/objectionary/eo-lsp-server)
[![Hits-of-Code](https://hitsofcode.com/github/objectionary/eo-lsp-server)](https://hitsofcode.com/view/github/objectionary/eo-lsp-server)

This is the [LSP] server for [EO](https://github.com/objectionary/eo).
It provides semantic highlighting and parsing error checking for `.eo` files
(written in [EOLANG]).
In order to use it, you need to have [Node] and [npm] installed.

## Using with IntelliJ (with LSP4IJ)

[LSP4IJ](https://github.com/redhat-developer/lsp4ij), a free LSP support plugin
for [IntelliJ], provides an [EO LSP server template][lsp4ij-doc]
to automatically install and run the `LSP Server for EOLANG`:

* Install [LSP4IJ](https://plugins.jetbrains.com/plugin/23257-lsp4ij)
into [IntelliJ]
* Open any `*.eo` file, a notification will appear with
`Install LSP Server for EOLANG`
* Click the link, confirm the server creation, then click `OK`
* The server will be installed (via [npm])

Once done, semantic tokens and diagnostics will be available.

## Using with Sublime Text

To use this [LSP] server with [Sublime Text], you'll need to install
the [LSP package] and configure it
in `Settings → Package Settings → LSP → Settings`:

```json
{
  "clients": {
    "eo-lsp": {
      "enabled": true,
      "command": ["npx", "-y", "eo-lsp-server@0.4.0", "--stdio"],
      "selector": "source.eo"
    }
  }
}
```

Then, create a syntax definition file [in][packages]
`~/Library/Application Support/Sublime Text/Packages/User/EO.sublime-syntax`:

```yaml
%YAML 1.2
---
name: EO
file_extensions:
  - eo
scope: source.eo
contexts:
  main:
    - match: '^\+[^\n]+$'
      scope: meta.eo
    - match: '#.*$'
      scope: comment.line.eo
    - match: '[@^*?]'
      scope: keyword.eo
    - match: '[\[\]\\>!:\.\)\(]|\+>'
      scope: keyword.operator.eo
    - match: '"[^"]*"'
      scope: string.quoted.double.eo
    - match: '\b(\+|-)?\d+(\.\d+(e(\+|-)?\d)?)?\b'
      scope: constant.numeric.eo
```

Should work. If it doesn't, [file an issue], we'll help.

## How to Contribute

First, install [Node] modules with:

```bash
npm install
```

Then, build the project:

```bash
make
```

Make changes on a new branch.
You can run an instance of [VS Code] with the extension running by hitting `F5`
in the code editor.
After modifications, test your code with:

```bash
make test
```

Create a pull request, we'll be glad to review it and merge.

[LSP package]: https://packagecontrol.io/packages/LSP
[LSP]: https://en.wikipedia.org/wiki/Language_Server_Protocol
[EOLANG]: https://www.eolang.org
[Sublime Text]: https://www.sublimetext.com/
[file an issue]: https://github.com/objectionary/eo-lsp-server/issues
[Node]: https://nodejs.org/en
[VS Code]: https://code.visualstudio.com/
[packages]: https://forum.sublimetext.com/t/sublimetext-3-where-are-the-packages/9484
[lsp4ij-doc]: https://github.com/redhat-developer/lsp4ij/blob/main/docs/user-defined-ls/eo-lsp-server.md
[IntelliJ]: https://www.jetbrains.com/idea/
[npm]: https://www.npmjs.com/
