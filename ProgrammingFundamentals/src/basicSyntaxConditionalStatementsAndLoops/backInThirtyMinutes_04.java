package basicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class backInThirtyMinutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = hours * 60 + minutes + 30;

        int finalHours = allMinutes / 60;
        if (finalHours > 23) {
            finalHours = 0;
        }
        int finalMinutes = allMinutes % 60;

        System.out.printf("%01d:%02d", finalHours, finalMinutes);
    }
}
