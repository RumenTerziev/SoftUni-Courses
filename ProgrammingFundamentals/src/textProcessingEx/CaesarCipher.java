package textProcessingEx;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= text.length() - 1; i++) {
            char currentSymbol = text.charAt(i);
            int resultCodePoint = currentSymbol + 3;
            char resultSymbol = (char) resultCodePoint;
            result.append(resultSymbol);
        }
        System.out.println(result);
    }
}
