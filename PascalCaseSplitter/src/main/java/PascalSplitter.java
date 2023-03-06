import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> words = new ArrayList<>();

        if (isValidInput(text)) {

            StringBuilder currentWord = new StringBuilder();
            currentWord.append(text.charAt(0));

            for (int i = 1; i < text.length(); i++) {

                char currentSymbol = text.charAt(i);

                if (Character.isLowerCase(currentSymbol)) {
                    currentWord.append(currentSymbol);
                } else if (Character.isUpperCase(currentSymbol)) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                    currentWord.append(currentSymbol);
                }

                if (i == text.length() - 1) {
                    words.add(currentWord.toString());
                }

            }


            for (String word : words) {
                System.out.println(word);
            }

        } else {
            System.out.println("The input is not valid!!!");
        }


    }


    private static boolean isValidInput(String input) {

        if (Character.isLowerCase(input.charAt(0))) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (!Character.isAlphabetic(currentSymbol)) {
                return false;
            }
        }
        return true;
    }
}
