package mapsLambdaStreamApi_ex;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceSides = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Lumpawaroo")) {

            if (command.contains("|")) {
                String[] commandLine = command.split(" \\| ");
                String forceSide = commandLine[0];
                String user = commandLine[1];

                forceSides.putIfAbsent(forceSide, new ArrayList<>());

                boolean isExist = false;
                for (Map.Entry<String, List<String>> entry : forceSides.entrySet()) {
                    if (entry.getValue().contains(user)) {
                        isExist = true;
                        break;
                    }

                }
                if (!isExist) {
                    forceSides.get(forceSide).add(user);
                }

            } else if (command.contains("->")) {
                String[] commandLine = command.split(" -> ");
                String forceSide = commandLine[1];
                String user = commandLine[0];

                forceSides.putIfAbsent(forceSide, new ArrayList<>());
                boolean isExist = false;
                for (Map.Entry<String, List<String>> entry : forceSides.entrySet()) {
                    if (entry.getValue().contains(user)) {
                        isExist = true;
                        entry.getValue().remove(user);
                    }
                }
                if (!isExist) {
                    forceSides.get(forceSide).add(user);
                    System.out.printf("%s joins the %s side!%n", user, forceSide);
                } else {
                    forceSides.get(forceSide).add(user);
                    System.out.printf("%s joins the %s side!%n", user, forceSide);

                }


            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : forceSides.entrySet()) {

            if (entry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (String element : entry.getValue()) {
                    System.out.printf("! %s%n", element);
                }
            }
        }
    }
}
