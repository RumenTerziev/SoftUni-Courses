package methods_ex;

import com.sun.jdi.CharValue;

import java.util.Scanner;

public class charactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        printCharactersInRange(firstSymbol, secondSymbol);

    }

    private static void printCharactersInRange(char symbolOne, char symbolTwo) {
        if (symbolOne <= symbolTwo) {
            for (int i = symbolOne + 1; i < symbolTwo; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        } else {
            for (int i = symbolTwo + 1; i < symbolOne; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        }
    }
}
