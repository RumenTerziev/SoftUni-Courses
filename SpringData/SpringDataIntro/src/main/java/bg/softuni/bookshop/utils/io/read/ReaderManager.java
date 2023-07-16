package bg.softuni.bookshop.utils.io.read;


import java.io.FileNotFoundException;

public class ReaderManager {

    public static FileReader getFileReader(String filePath) throws FileNotFoundException {
        return new FileReader(filePath);
    }

    public static SysInReader getSysInReader() {
        return new SysInReader();
    }
}
