package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private final Logger log = LogManager.getLogger("AUTOMATION");

    private void printSeparator() {
        this.log.info("------------------------------------------------------------------------------------------");
    }

    private void printNewLine() {
        this.log.info("");
    }

    public Logs() {
    }

    public void info(String message) {
        this.log.info(message);
    }

    public void warn(String message) {
        this.log.warn(message);
    }

    public void error(String message) {
        this.log.error(message);
    }

    public void debug(String message) {
        this.log.debug(message);
    }
}
