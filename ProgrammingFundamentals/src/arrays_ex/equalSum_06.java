package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class equalSum_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isFound = false;
        for (int index = 0; index <= numbersArr.length - 1; index++) {
            int currentElement = numbersArr[index];

            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                int leftElement = numbersArr[leftIndex];
                leftSum = leftSum + leftElement;
            }

            for (int rightIndex = index + 1; rightIndex <= numbersArr.length - 1; rightIndex++) {
                int rightElement = numbersArr[rightIndex];
                rightSum = rightSum + rightElement;
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
