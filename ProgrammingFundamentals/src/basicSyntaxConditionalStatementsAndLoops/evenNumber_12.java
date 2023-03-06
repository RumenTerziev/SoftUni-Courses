package basicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class evenNumber_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialNumber = Integer.parseInt(scanner.nextLine());

        while (initialNumber % 2 != 0) {
            System.out.println("Please write an even number.");
            initialNumber = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The number is: %d", Math.abs(initialNumber));
    }
}
