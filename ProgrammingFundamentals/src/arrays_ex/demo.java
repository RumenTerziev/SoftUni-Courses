package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int [] secondArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int [] concatenatedArray = new int[array.length + secondArray.length];


        for (int index = 0; index <= array.length - 1; index++) {
          concatenatedArray[index] = array[index];
        }
        for (int i = array.length; i <= concatenatedArray.length - 1; i++) {
          concatenatedArray[i] = secondArray[i - array.length];
        }
        for (int element : concatenatedArray) {
            System.out.print(element + " ");
        }
    }
}
