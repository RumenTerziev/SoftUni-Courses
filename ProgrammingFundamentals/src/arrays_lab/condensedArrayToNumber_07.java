package arrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class condensedArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        if (numbersArr.length > 1) {
            int index = 0;
            while (true) {
                int[] condensedArr = new int[numbersArr.length - 1 - index];
                for (int i = 0; i < condensedArr.length; i++) {
                    condensedArr[i] = numbersArr[i] + numbersArr[i + 1];
                    numbersArr[i] = condensedArr[i];

                }
                numbersArr[numbersArr.length - 1 - index] = 0;

                if (condensedArr.length == 1) {
                    break;
                }
                index++;
            }
            System.out.println(numbersArr[0]);
        } else if (numbersArr.length == 1) {
            System.out.println(numbersArr[0]);
        }
    }
}
