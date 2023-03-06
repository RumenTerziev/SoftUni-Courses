package textProcessing;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String reversedText = "";
            for (int i = command.length() - 1; i >= 0; i--) {
                char currentSymbol = command.charAt(i);
                reversedText = reversedText + currentSymbol;
            }

            System.out.printf("%s = %s%n", command, reversedText);

            command = scanner.nextLine();
        }


    }
}
