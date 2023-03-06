package setsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNames = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int index = 0; index < countNames; index++) {

            String currentName = scanner.nextLine();

            usernames.add(currentName);
        }

        usernames.forEach(System.out::println);
    }
}
