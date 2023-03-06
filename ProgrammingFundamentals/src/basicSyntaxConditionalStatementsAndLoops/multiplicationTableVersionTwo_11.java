package basicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class multiplicationTableVersionTwo_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startingMultiplier = Integer.parseInt(scanner.nextLine());

        int product = 0;
        for (int i = startingMultiplier; i <= 10; i++) {
            product = number * i;
            System.out.printf("%d X %d = %d%n", number, i, product);
        }
        if (startingMultiplier > 10) {
            product = number * startingMultiplier;
            System.out.printf("%d X %d = %d", number, startingMultiplier, product);
        }
    }
}
