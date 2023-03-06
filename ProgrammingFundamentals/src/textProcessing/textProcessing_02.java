package textProcessing;

import java.util.Scanner;

public class textProcessing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        while (!command.equals("end")) {

            StringBuilder reversed = new StringBuilder();
            for (int i = command.length() - 1; i >= 0; i--) {
                char currentSymbol = command.charAt(i);
                reversed.append(currentSymbol);
            }

            System.out.printf("%s = %s%n", command, reversed);
            command = scanner.nextLine();
        }

    }
}
