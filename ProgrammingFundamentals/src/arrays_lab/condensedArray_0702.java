package arrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class condensedArray_0702 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (numbersArr.length != 1) {
            int [] newArray = new int [numbersArr.length - 1];
            for (int i = 0; i < numbersArr.length - 1; i++) {
                newArray[i] = numbersArr[i] + numbersArr[i + 1];
            }
            numbersArr = newArray;
        }
        System.out.println(numbersArr[0]);
    }
}
