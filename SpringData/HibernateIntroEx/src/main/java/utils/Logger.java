package utils;

import java.io.PrintStream;

public class Logger {
    private final PrintStream printStream;

    public Logger(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void log(String input) {
        printStream.println(input);
    }
}
