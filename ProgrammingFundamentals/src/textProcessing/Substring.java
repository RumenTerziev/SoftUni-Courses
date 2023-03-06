package textProcessing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String stringToCheck = scanner.nextLine();
        String resultString = "";


        while (stringToCheck.contains(toRemove)) {
            if (stringToCheck.contains(toRemove)) {
                resultString = stringToCheck.replace(toRemove, "");
            }
            stringToCheck = resultString;
        }


        System.out.println(resultString);
    }
}
