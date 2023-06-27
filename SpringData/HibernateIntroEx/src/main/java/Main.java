import utils.Logger;
import utils.Reader;
import utils.TaskManager;

import java.io.InputStreamReader;
import java.io.PrintStream;


public class Main {

    public static void main(String[] args) {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        PrintStream printStream = new PrintStream(System.out);
        Reader reader = new Reader(inputStreamReader);
        Logger logger = new Logger(printStream);

        TaskManager taskManager = new TaskManager(reader, logger);

        try {
            taskManager.solve();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
