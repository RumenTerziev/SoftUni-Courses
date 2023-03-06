package arrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class equalArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean areNotIdentical = false;
        int sum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            int currentNumOne = firstArray[i];
            sum += currentNumOne;
            int currentNumTwo = secondArray[i];

            if (currentNumOne != currentNumTwo) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areNotIdentical = true;
                break;
            }
        }
        if (!areNotIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }

    }
}
