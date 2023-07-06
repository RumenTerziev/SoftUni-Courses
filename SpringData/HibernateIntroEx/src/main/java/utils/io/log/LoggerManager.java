package utils.io.log;

public class LoggerManager {

    public static Logger getLogger() {
        return new SysOutLogger();
    }

}
