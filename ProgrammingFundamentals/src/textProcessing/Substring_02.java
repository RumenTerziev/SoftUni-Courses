package textProcessing;

import java.util.Scanner;

public class Substring_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String toCheck = scanner.nextLine();

        int index = toCheck.indexOf(toRemove);
        while (index != -1) {

            toCheck = toCheck.replace(toCheck.substring(index, index + toRemove.length()), "");
            index = toCheck.indexOf(toRemove);

        }
        System.out.println(toCheck);
    }
}
