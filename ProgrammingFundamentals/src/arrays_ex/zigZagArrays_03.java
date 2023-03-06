package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class zigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        int row = 0;
        for (int i = 0; i < n; i++) {
            row++;
            int[] initialArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (row % 2 == 0) {
                secondArray[i] = initialArray[0];
                firstArray[i] = initialArray[1];
            } else {
                firstArray[i] = initialArray[0];
                secondArray[i] = initialArray[1];
            }
        }
        for (int elementOne : firstArray) {
            System.out.print(elementOne + " ");
        }
        System.out.println();
        for (int elementTwo : secondArray) {
            System.out.print(elementTwo + " ");
        }
    }
}
