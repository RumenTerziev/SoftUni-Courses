package setsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();


        String command = scanner.nextLine();
        while (!command.equals("search")) {

            String[] contactInfo = command.split("-");
            String name = contactInfo[0];
            String number = contactInfo[1];

            phonebook.put(name, number);

            command = scanner.nextLine();
        }


        command = scanner.nextLine();
        while (!command.equals("stop")) {

            String name = command;

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }


            command = scanner.nextLine();
        }
    }
}
