package utils;

import utils.interfaces.Logger;

public class SysOutLogger implements Logger {

    @Override
    public void log(String outputMassage) {
        System.out.println(outputMassage);
    }
}
