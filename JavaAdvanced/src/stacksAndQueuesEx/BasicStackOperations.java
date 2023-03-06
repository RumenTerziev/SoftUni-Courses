package stacksAndQueuesEx;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] inputData = getIntegers(input);
        int[] numbers = getIntegers(scanner.nextLine());

        int countElementsToPush = inputData[0];
        int countToPop = inputData[1];
        int searchedNumber = inputData[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countElementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (stack.contains(searchedNumber)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }

    public static int[] getIntegers(String string) {
        return Arrays.stream(string.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
