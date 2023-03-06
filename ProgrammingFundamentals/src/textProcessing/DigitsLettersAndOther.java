package textProcessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<Character> digitsList = new ArrayList<>();
        List<Character> lettersList = new ArrayList<>();
        List<Character> otherSymbolsList = new ArrayList<>();

        for (int i = 0; i <= text.length() - 1; i++) {
            char currentSymbol = text.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                digitsList.add(currentSymbol);
            } else if (Character.isLetter(currentSymbol)) {
                lettersList.add(currentSymbol);
            } else {
                otherSymbolsList.add(currentSymbol);
            }
        }
        for (char symbol : digitsList) {
            System.out.print(symbol);
        }
        System.out.println();
        for (char symbol : lettersList) {
            System.out.print(symbol);
        }
        System.out.println();
        for (char symbol : otherSymbolsList) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
