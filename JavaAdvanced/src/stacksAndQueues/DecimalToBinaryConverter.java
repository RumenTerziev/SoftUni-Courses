package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int decimalNumber = Integer.parseInt(scanner.nextLine());

        if (decimalNumber == 0) {
            System.out.println("0");
        } else {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            while (decimalNumber != 0) {

                stack.push(decimalNumber % 2);
                decimalNumber /= 2;
            }


            for (int number : stack) {
                System.out.print(number);
            }
        }
    }
}
