package softuni.exam.util.io.read;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileReader {

    public String readAllData(String filePath) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(filePath);
        String result = new String(inputStream.readAllBytes());
        inputStream.close();

        return result;
    }
}
