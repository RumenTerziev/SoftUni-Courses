package regularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(?<name>[A-Z][a-z]+) (?<surname>[A-Z][a-z]+\\b)");
        Matcher fullName = pattern.matcher(input);

        while (fullName.find()) {
            System.out.print(fullName.group() + " ");
        }
    }
}
