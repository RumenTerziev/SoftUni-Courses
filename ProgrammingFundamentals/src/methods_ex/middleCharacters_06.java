package methods_ex;

import java.util.Scanner;

public class middleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        if (text.length() % 2 == 0) {
            findTwoMiddleCharacters(text);
        } else findMiddleCharacter(text);
    }

    private static void findMiddleCharacter(String text) {
        char[] symbols = text.toCharArray();
        int middleIndex = text.length() / 2;
        char middleCharacter = symbols[middleIndex];
        System.out.println(middleCharacter);
    }

    private static void findTwoMiddleCharacters(String text) {
        char[] symbols = text.toCharArray();
        int secondMiddleIndex = text.length() / 2;
        int firstMiddleIndex = secondMiddleIndex - 1;

        char firstMiddleCharacter = symbols[firstMiddleIndex];
        char secondMiddleCharacter = symbols[secondMiddleIndex];
        System.out.println("" + firstMiddleCharacter + secondMiddleCharacter);
    }
}
