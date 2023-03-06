package dataTypesAndVariables;

import java.util.Scanner;

public class triplesOfLatinLetters_0602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        for (char symbolOne = 'a'; symbolOne < 'a' + number; symbolOne++) {
            for (char symbolTwo = 'a'; symbolTwo < 'a' + number; symbolTwo++) {
                for (char symbolThree = 'a'; symbolThree < 'a' + number; symbolThree++) {

                    System.out.printf("%c%c%c%n", symbolOne, symbolTwo, symbolThree);
                }
            }
        }

    }
}
