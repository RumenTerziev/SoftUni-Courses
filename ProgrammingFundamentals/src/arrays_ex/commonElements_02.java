package arrays_ex;

import java.util.Scanner;

public class commonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");


        for (String elementTwo : secondArray) {
            for (String elementOne : firstArray) {
                if (elementTwo.equals(elementOne)) {
                    System.out.print(elementTwo + " ");
                }
            }
        }
    }
}
