package utils.io.log;

import utils.io.log.Logger;

public class SysOutLogger implements Logger {

    @Override
    public void log(String outputMassage) {
        System.out.println(outputMassage);
    }
}
