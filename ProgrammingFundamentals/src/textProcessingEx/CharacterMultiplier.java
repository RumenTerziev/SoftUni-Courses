package textProcessingEx;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsArr = scanner.nextLine().split(" ");

        String firstString = stringsArr[0];
        String secondString = stringsArr[1];


        int sum = sumOfStringCharacters(firstString, secondString);
        System.out.println(sum);

    }

    public static Integer sumOfStringCharacters(String first, String second) {

        int sum = 0;
        if (first.length() == second.length()) {
            for (int i = 0; i <= first.length() - 1; i++) {
                char firstCharacter = first.charAt(i);
                char secondCharacter = second.charAt(i);
                sum += firstCharacter * secondCharacter;
            }

        } else {
            int minLength = Math.min(first.length(), second.length());
            for (int i = 0; i <= minLength - 1; i++) {
                char firstCharacter = first.charAt(i);
                char secondCharacter = second.charAt(i);
                sum += firstCharacter * secondCharacter;
            }
            if (first.length() > second.length()) {
                for (int i = minLength; i <= first.length() - 1; i++) {
                    char currentSymbol = first.charAt(i);
                    sum += currentSymbol;
                }
            } else {
                for (int i = minLength; i <= second.length() - 1; i++) {
                    char currentSymbol = second.charAt(i);
                    sum += currentSymbol;
                }
            }
        }
        return sum;
    }
}
