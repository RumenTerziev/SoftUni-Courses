package methods_ex;

import java.util.Arrays;
import java.util.Scanner;

public class smallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        int[] numbers = new int[] {firstNum, secondNum, thirdNum};

        System.out.println(findMin(numbers));
    }

    public static int findMin(int[] array) {

        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i <= array.length - 1; i++) {
            int currentNumber = array[i];
            if (currentNumber <= minNumber) {
                minNumber = currentNumber;
            }
        }

        return minNumber;
    }
}
