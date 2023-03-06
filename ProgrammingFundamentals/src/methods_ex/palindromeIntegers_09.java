package methods_ex;

import java.util.Scanner;

public class palindromeIntegers_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            int number = Integer.parseInt(command);

            System.out.println(isPalindrome(number));

            command = scanner.nextLine();
        }

    }

    private static boolean isPalindrome(int number) {

        String textNum = "" + number;
        String reversedTextNum = "";

        while (number > 0) {
            int lastDigit = number % 10;
            reversedTextNum = reversedTextNum + "" + lastDigit;


            number = number / 10;
        }
        return textNum.equals(reversedTextNum);
    }

}
