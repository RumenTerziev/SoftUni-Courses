package utils;

import utils.interfaces.Reader;

public class ReaderManager {

    public static Reader getReader() {
        return new SysInReader();
    }
}
