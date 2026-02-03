
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private BufferedWriter writer;
    private String fileName;

    // Private constructor (Singleton rule)
    private Logger() {
        this.fileName = "log.txt"; // default file name
        openFile();
    }

    // Singleton access method
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile() {
        try {
            // append = true so we don't overwrite old logs
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
            writer = null;
        }
    }

    public synchronized void write(String message) {
        if (writer == null) {
            System.err.println("Logger not ready (file could not be opened). Message not written: " + message);
            return;
        }

        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Change log file dynamically
    public synchronized void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile();
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }
}
