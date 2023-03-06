package methods_ex;

import java.util.Scanner;

public class topNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= number; i++) {
            if (isDivisible(i) && isHoldingAnOddDigit(i)) {
                System.out.println(i);
            }
        }

    }

    private static boolean isDivisible(int num) {

        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;

            num = num / 10;
        }
        return sum % 8 == 0;
    }

    private static boolean isHoldingAnOddDigit(int num) {

        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }

            num = num / 10;
        }
        return false;
    }
}
