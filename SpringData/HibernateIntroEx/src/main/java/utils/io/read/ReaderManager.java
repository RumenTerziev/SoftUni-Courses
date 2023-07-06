package utils.io.read;

public class ReaderManager {

    public static Reader getReader() {
        return new SysInReader();
    }
}
