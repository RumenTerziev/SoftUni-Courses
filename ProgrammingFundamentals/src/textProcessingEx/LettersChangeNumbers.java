package textProcessingEx;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] codes = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (int i = 0; i <= codes.length - 1; i++) {
            String currentCode = codes[i];


            char firstLetter = currentCode.charAt(0);
            char lastLetter = currentCode.charAt(currentCode.length() - 1);
            double number = Double.parseDouble(currentCode.replace(firstLetter, ' ')
                    .replace(lastLetter, ' ').trim());


            number = modifyNumber(firstLetter, lastLetter, number);
            sum += number;


        }
        System.out.printf("%.2f", sum);
    }

    private static double modifyNumber(char letter, char lastLetter, double number) {

        if (Character.isUpperCase(letter)) {
            int letterPosition = (int) letter - 64;
            number /= letterPosition;

        } else if (Character.isLowerCase(letter)) {
            int letterPosition = (int) letter - 96;
            number *= letterPosition;
        }

        if (Character.isUpperCase(lastLetter)) {
            int letterPosition = (int) lastLetter - 64;
            number -= letterPosition;

        } else if (Character.isLowerCase(lastLetter)) {
            int letterPosition = (int) lastLetter - 96;
            number += letterPosition;

        }
        return number;
    }
}
