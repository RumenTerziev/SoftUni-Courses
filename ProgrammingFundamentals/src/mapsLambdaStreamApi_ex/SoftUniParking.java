package mapsLambdaStreamApi_ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registeredUsers = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split(" ");

            String typeOfCommand = commandLine[0];
            String name = commandLine[1];

            switch (typeOfCommand) {
                case "register":
                    String plateNumber = commandLine[2];
                    if (!registeredUsers.containsKey(name)) {
                        registeredUsers.put(name, plateNumber);
                        System.out.printf("%s registered %s successfully%n", name, registeredUsers.get(name));
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", registeredUsers.get(name));
                    }

                    break;
                case "unregister":
                    if (registeredUsers.containsKey(name)) {
                        System.out.printf("%s unregistered successfully%n", name);
                        registeredUsers.remove(name, registeredUsers.get(name));
                    } else {
                        System.out.printf("ERROR: user %s not found%n", name);
                    }
                    break;
            }
        }
        registeredUsers.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }
}
