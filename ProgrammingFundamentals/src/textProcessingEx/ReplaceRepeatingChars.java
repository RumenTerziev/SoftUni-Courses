package textProcessingEx;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i <= input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);
            if (i == 0) {
                System.out.print(currentSymbol);
            } else {
                if (currentSymbol != input.charAt(i - 1)) {
                    System.out.print(currentSymbol);
                }
            }
        }
    }
}
