package streamsFilesDirectoriesEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resourcesNew01/input.txt"));

        int sumOfSymbols = 0;
        String newLine = bufferedReader.readLine();
        while (newLine != null) {


            for (int i = 0; i < newLine.length(); i++) {
                char currentSymbol = newLine.charAt(i);
                sumOfSymbols += currentSymbol;
            }
            newLine = bufferedReader.readLine();
        }
        System.out.println(sumOfSymbols);
        bufferedReader.close();
    }
}
