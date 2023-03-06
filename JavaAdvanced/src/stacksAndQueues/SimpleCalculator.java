package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        int[] integers = Arrays.stream(input.split("\\s+[-+]\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int number : integers) {
            queue.offer(number);
        }


        int result = queue.poll();


        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '+') {
                if (!queue.isEmpty()) {
                    result += queue.poll();
                }
            } else if (currentSymbol == '-') {
                if (!queue.isEmpty()) {
                    result -= queue.poll();
                }
            }
        }


        System.out.println(result);


    }
}
