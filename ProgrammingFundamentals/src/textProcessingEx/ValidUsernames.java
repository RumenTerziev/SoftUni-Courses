package textProcessingEx;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernamesArr = scanner.nextLine().split(", ");


        for (int i = 0; i <= usernamesArr.length - 1; i++) {
            String currentUser = usernamesArr[i];
            boolean isValid = true;
            for (int j = 0; j <= currentUser.length() - 1; j++) {

                char currentSymbol = currentUser.charAt(j);
                if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '_' && currentSymbol != '-') {
                    isValid = false;
                }
            }
            if (isValid && currentUser.length() >= 3 && currentUser.length() <= 16) {
                System.out.println(currentUser);
            }
        }
    }
}
