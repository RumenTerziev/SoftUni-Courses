package stacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        int[] data = getNumbers(inputLine);
        int[] numbers = getNumbers(scanner.nextLine());

        int countElementsToOffer = data[0];
        int countToPoll = data[1];
        int number = data[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countElementsToOffer; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(number)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }

    public static int[] getNumbers(String string) {
        return Arrays.stream(string.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
