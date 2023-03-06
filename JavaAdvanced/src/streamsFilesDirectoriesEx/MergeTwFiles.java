package streamsFilesDirectoriesEx;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwFiles {
    public static void main(String[] args) throws IOException {


        Path firstFile = Paths.get("src/resourcesNew01/inputOne.txt");
        List<String> firstLines = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("src/resourcesNew01/inputTwo.txt");
        List<String> secondLines = Files.readAllLines(secondFile);

        Path output = Paths.get("output.txt");
        Files.write(output, firstLines, StandardOpenOption.APPEND);
        Files.write(output, secondLines, StandardOpenOption.APPEND);

    }
}
