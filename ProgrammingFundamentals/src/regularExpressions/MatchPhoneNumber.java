package regularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}\\b");
        Matcher phoneNumber = pattern.matcher(input);


        List<String> phoneNumbersList = new ArrayList<>();
        while (phoneNumber.find()) {
            phoneNumbersList.add(phoneNumber.group());
        }

        for (int i = 0; i <= phoneNumbersList.size() - 1; i++) {
            if (i != phoneNumbersList.size() - 1) {
                System.out.print(phoneNumbersList.get(i) + ", ");
            } else if (i == phoneNumbersList.size() - 1) {
                System.out.print(phoneNumbersList.get(i));
            }
        }
    }
}
