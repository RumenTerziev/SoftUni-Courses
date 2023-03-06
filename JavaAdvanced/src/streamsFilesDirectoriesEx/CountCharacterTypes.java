package streamsFilesDirectoriesEx;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("src/resourcesNew01/input.txt");
        FileWriter fileWriter = new FileWriter("output.txt");

        int oneByte = fileReader.read();

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;
        while (oneByte >= 0) {

            char currentSymbol = (char) oneByte;

            if (isVowel(currentSymbol)) {
                vowelCount++;
            } else if (isPunctuation(currentSymbol)) {
                punctuationCount++;
            } else if (!Character.isWhitespace(currentSymbol)) {
                consonantCount++;
            }


            oneByte = fileReader.read();
        }

        fileWriter.write(String.format("Vowels: %d%n", vowelCount));
        fileWriter.write(String.format("Consonants: %d%n", consonantCount));
        fileWriter.write(String.format("Punctuation: %d%n", punctuationCount));

        fileReader.close();
        fileWriter.close();

    }

    private static boolean isPunctuation(char currentSymbol) {
        return currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?';
    }

    private static boolean isVowel(char currentSymbol) {
        return currentSymbol == 'a' || currentSymbol == 'o' || currentSymbol == 'u' || currentSymbol == 'e' || currentSymbol == 'i';
    }
}
