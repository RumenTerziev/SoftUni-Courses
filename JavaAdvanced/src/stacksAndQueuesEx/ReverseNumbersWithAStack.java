package stacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> integersStack = new ArrayDeque<>();

        for (int number : numbers) {
            integersStack.push(number);
        }

        while (!integersStack.isEmpty()) {
            System.out.print(integersStack.pop() + " ");
        }
    }
}
