package arrays_lab;

import java.util.Scanner;

public class reverseAnArrayOfStrings_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsArr = scanner.nextLine().split(" ");

        for (int i = 0; i < stringsArr.length / 2; i++) {
            String initialString = stringsArr[i];
            stringsArr[i] = stringsArr[stringsArr.length - 1 - i];
            stringsArr[stringsArr.length - 1 - i] = initialString;

        }
        for (String element : stringsArr) {
            System.out.print(element + " ");
        }
    }
}
