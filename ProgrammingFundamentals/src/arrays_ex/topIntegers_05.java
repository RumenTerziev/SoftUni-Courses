package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class topIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numbersArray.length - 1; index++) {
            int currentElement = numbersArray[index];
            boolean isBigger = false;
            for (int rightIndex = index + 1; rightIndex <= numbersArray.length - 1; rightIndex++) {
                int rightElement = numbersArray[rightIndex];
                if (currentElement > rightElement) {
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(currentElement + " ");
            }
        }
        System.out.println(numbersArray[numbersArray.length - 1]);
    }
}
