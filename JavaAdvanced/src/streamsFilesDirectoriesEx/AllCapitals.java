package streamsFilesDirectoriesEx;

import java.io.*;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resourcesNew01/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String newLine = bufferedReader.readLine();
        while (newLine != null) {

            newLine = newLine.toUpperCase();
            bufferedWriter.write(newLine);

            newLine = bufferedReader.readLine();
            if (newLine != null) {
                bufferedWriter.write(System.lineSeparator());
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
