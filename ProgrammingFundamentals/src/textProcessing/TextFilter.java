package textProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();


        for (int i = 0; i <= bannedWords.length - 1; i++) {
            String bannedWord = bannedWords[i];
            text = text.replace(text.substring(text.indexOf(bannedWord)
                    , text.indexOf(bannedWord) + bannedWord.length()), replacementString(bannedWord));

        }

        System.out.println(text);
    }

    private static String replacementString(String text) {

        int counter = 0;
        for (int i = 0; i <= text.length() - 1; i++) {
            counter++;
        }
        String result = "";
        for (int i = 0; i < counter; i++) {
            result = result.concat("*");
        }
        return result;
    }
}
