import java.util.Scanner;

public class refactorSpecialNumbers_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        boolean isSpecial = false;
        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            int sum = 0;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                isSpecial = true;
            } else {
                isSpecial = false;
            }

            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }

    }
}
