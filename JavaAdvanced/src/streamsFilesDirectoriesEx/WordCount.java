package streamsFilesDirectoriesEx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {

        Scanner wordsScanner = new Scanner(new FileReader("src/resourcesNew01/words.txt"));

        String input = wordsScanner.nextLine();
        String[] words = input.split("\\s+");

        Scanner stringScanner = new Scanner(new FileReader("src/resourcesNew01/text.txt"));

        Map<String, Integer> occurrencesMap = new HashMap<>();

        for (String word : words) {
            occurrencesMap.putIfAbsent(word, 0);
        }

        String currentWord = stringScanner.next();
        while (stringScanner.hasNext()) {

            if (occurrencesMap.containsKey(currentWord)) {
                int occurrences = occurrencesMap.get(currentWord);
                occurrences++;
                occurrencesMap.put(currentWord, occurrences);
            }

            currentWord = stringScanner.next();
        }

        PrintWriter printWriter = new PrintWriter("results.txt");

        occurrencesMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(stringIntegerEntry -> {
            printWriter.write(String.format("%s - %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        });

        wordsScanner.close();
        stringScanner.close();
        printWriter.close();

    }
}
