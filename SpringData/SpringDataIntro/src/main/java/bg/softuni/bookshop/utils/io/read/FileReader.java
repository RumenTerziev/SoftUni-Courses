package bg.softuni.bookshop.utils.io.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements Reader {


    private final BufferedReader bufferedReader;

    public FileReader(String filePath) throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }

}
