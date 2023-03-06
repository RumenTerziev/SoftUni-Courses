package stacksAndQueuesEx;

import java.util.*;


public class FibonacciWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        if (number < 2) {
            System.out.println("1");
            return;
        } else {

            for (int i = 0; i < number; i++) {
                long numberOne = stack.pop();
                long numberTwo = stack.pop();
                stack.push(numberOne);
                stack.push(numberOne + numberTwo);
            }
            System.out.println(stack.pop());
        }

    }
}
