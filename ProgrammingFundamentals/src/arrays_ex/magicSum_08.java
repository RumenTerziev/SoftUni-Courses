package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class magicSum_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] newArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < newArr.length - 1; i++) {
            int currentElement = newArr[i];
            for (int j = i + 1; j <= newArr.length - 1; j++) {
                int nextElement = newArr[j];

                if (currentElement + newArr[j] == n) {
                    System.out.printf("%d %d%n", currentElement, newArr[j]);
                }
            }
        }


    }
}
