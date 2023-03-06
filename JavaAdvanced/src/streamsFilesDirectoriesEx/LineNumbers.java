package streamsFilesDirectoriesEx;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args)  throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resourcesNew01/inputLineNumbers.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        String newLine = bufferedReader.readLine();


        int counter = 1;
        while (newLine != null) {

            bufferedWriter.write(String.format("%d. %s", counter, newLine));

            counter++;

            newLine = bufferedReader.readLine();
            if (newLine != null) {
                bufferedWriter.write(System.lineSeparator());
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
