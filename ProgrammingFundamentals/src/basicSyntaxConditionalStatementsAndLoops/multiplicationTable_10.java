package basicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class multiplicationTable_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int product = 0;
        for (int i = 1; i <= 10; i++) {
            product = number * i;
            System.out.printf("%d X %d = %d%n", number, i, product);
        }
    }
}
