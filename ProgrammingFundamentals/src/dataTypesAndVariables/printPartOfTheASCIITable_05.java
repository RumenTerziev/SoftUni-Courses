package dataTypesAndVariables;

import java.util.Scanner;

public class printPartOfTheASCIITable_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstCode = Integer.parseInt(scanner.nextLine());
        int lastCode = Integer.parseInt(scanner.nextLine());

        for (int code = firstCode; code <= lastCode; code++) {
            char currentSymbol = (char) code;

            System.out.printf("%c ", currentSymbol);
        }
    }
}
