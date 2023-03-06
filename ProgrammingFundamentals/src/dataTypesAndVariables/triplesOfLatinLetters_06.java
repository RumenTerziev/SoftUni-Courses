package dataTypesAndVariables;

import java.util.Scanner;

public class triplesOfLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String result = "";
        for (int i = (int) 'a'; i < 'a' + number; i++) {
            for (int j = (int) 'a'; j < 'a' + number; j++) {
                for (int k = (int) 'a'; k < 'a' + number; k++) {
                    result = String.format("%c%c%c", i, j, k);
                    System.out.println(result);
                }
            }
        }

    }
}
