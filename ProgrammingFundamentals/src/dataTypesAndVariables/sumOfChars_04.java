package dataTypesAndVariables;

import java.util.Scanner;

public class sumOfChars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int symbolsCount = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 0; i < symbolsCount; i++) {

            char currentSymbol = scanner.nextLine().charAt(0);
            sum = sum + currentSymbol;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
