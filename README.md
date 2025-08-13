
# EO LSP Server

[![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/objectionary/eo-lsp-server/ci.yml?branch=master)](https://github.com/objectionary/eo-lsp-server/actions)  
[![codecov](https://codecov.io/gh/objectionary/eo-lsp-server/branch/master/graph/badge.svg)](https://codecov.io/gh/objectionary/eo-lsp-server)  
![Hits-of-Code](https://hitsofcode.com/github/objectionary/eo-lsp-server)

The **EO LSP Server** is a Language Server Protocol (LSP) implementation for the  
[EO programming language](https://www.eolang.org/).  
It provides:

- **Semantic highlighting**
- **Parsing error checking**
- Works with `.eo` files in any LSP-compatible editor/IDE (VS Code, Sublime Text, IntelliJ IDEA, etc.)

---

## Requirements

- [Node.js](https://nodejs.org/) **v14+**
- Any LSP-capable editor or IDE

---

## Installation

You can run EO LSP Server directly with `npx` (no installation needed):

```bash
npx -y eo-lsp-server@0.1.1 --stdio
````

Or install locally:

```bash
npm install eo-lsp-server
```

---

## Using with Editors

### VS Code

1. Install the **Language Server Protocol** client support (built-in for most languages).

2. Configure `.eo` files to use EO LSP Server via `.vscode/settings.json`:

   ```json
   {
     "lsp": {
       "eo-lsp": {
         "command": ["npx", "-y", "eo-lsp-server@0.1.1", "--stdio"],
         "fileTypes": ["eo"]
       }
     }
   }
   ```

3. Open a `.eo` file — the server should start automatically.

---

### Sublime Text

1. Install the **LSP** package from Package Control.

2. Add configuration in
   `Settings → Package Settings → LSP → Settings`:

   ```json
   {
     "clients": {
       "eo-lsp": {
         "enabled": true,
         "command": ["npx", "-y", "eo-lsp-server@0.1.1", "--stdio"],
         "selector": "source.eo"
       }
     }
   }
   ```

3. Create a syntax definition file at
   `Packages/User/EO.sublime-syntax`:

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

4. Restart Sublime Text.

---

### IntelliJ IDEA

IntelliJ IDEA does not natively support arbitrary LSP servers, but you can use
EO LSP Server with the **LSP Support** plugin.

**Steps:**

1. **Install the LSP Support Plugin**

   * Go to `File → Settings → Plugins`.
   * Search for **LSP Support**.
   * Install and restart IntelliJ IDEA.

2. **Configure EO LSP Server**

   * Go to
     `File → Settings → Languages & Frameworks → Language Server Protocol → Server Definitions`.

   * Click the **`+`** button to add a new server.

   * Select **Executable**.

   * In the `Command` field, enter:

     ```bash
     npx -y eo-lsp-server@0.1.1 --stdio
     ```

   * (Optional) Set the working directory to your EO project root.

3. **Map File Types**

   * In the LSP configuration, click **Add** under “File types”.
   * Select `*.eo`.

4. **Apply and Restart**

   * Click **OK** and restart IntelliJ IDEA.

5. **Verify**

   * Open a `.eo` file and check for syntax highlighting, error diagnostics,
     and other LSP features.

---

## Development

1. Install dependencies:

   ```bash
   npm install
   ```

2. Build the project:

   ```bash
   make
   ```

3. Run tests:

   ```bash
   make test
   ```

4. Debug in VS Code:

   * Open the project in VS Code.
   * Press **F5** to run with the EO LSP extension active.

---

## Contributing

We welcome contributions!

1. Fork the repository.

2. Create a new branch:

   ```bash
   git checkout -b feature/my-change
   ```

3. Make and test your changes:

   ```bash
   make test
   ```

4. Push your branch and open a Pull Request.

---

## License

[MIT](LICENSE)

---

**Links:**

* [EO Language Website](https://www.eolang.org/)
* [EO LSP Server on npm](https://www.npmjs.com/package/eo-lsp-server)
* [LSP Protocol Specification](https://microsoft.github.io/language-server-protocol/)

```
