package utils;

import utils.interfaces.Logger;

public class LoggerManager {

    public static Logger getLogger() {
        return new SysOutLogger();
    }

}
