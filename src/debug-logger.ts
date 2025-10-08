import * as fs from "fs";
import * as path from "path";


/**
 * Custom logger. Prints to the
 * `.../eo-lsp-server/dist/eo-lsp-debug.log`
 * file. May be more informative
 * then the **LSP Log Panel**.
 * */
export class CustomDebugLogger {
    private logFile: string;
    constructor(logFileName: string = "eo-lsp-debug.log") {
        this.logFile = path.join(__dirname, logFileName);
        fs.writeFileSync(this.logFile, `=== EO LSP Log Started ${new Date().toISOString()} ===\n`);
    }
    public log(message: string): void {
        const timestamp = new Date().toISOString();
        const logMessage = `[${timestamp} --- ${message}]`;
        fs.appendFileSync(this.logFile, logMessage);
    }
}
export const customDebugLogger = new CustomDebugLogger();
