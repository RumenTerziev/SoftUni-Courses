package setsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> validEmails = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("stop")) {

            String name = command;
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                validEmails.put(name, email);
            }


            command = scanner.nextLine();
        }

        validEmails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));

    }
}
