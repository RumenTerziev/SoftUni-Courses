package methods_ex;

import java.util.Scanner;

public class passwordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();

        if (!isValidLength(pass)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidContent(pass)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidDigitsCount(pass)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength(pass) && isValidContent(pass) && isValidDigitsCount(pass)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isValidContent(String password) {
        char[] symbols = password.toCharArray();
        for (int i = 0; i <= symbols.length - 1; i++) {
            char currentSymbol = symbols[i];
            if (!Character.isLetterOrDigit(currentSymbol)) {
                return false;
            }
        }

        return true;

    }

    private static boolean isValidDigitsCount(String password) {
        char[] symbols = password.toCharArray();
        int countDigits = 0;
        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;
    }

}
