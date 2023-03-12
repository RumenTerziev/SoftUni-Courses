package mapsMoreEx;

import java.util.*;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<List<String>, Integer> dwarves = new LinkedHashMap<>();


        String command = scanner.nextLine();
        while (!command.equals("Once upon a time")) {
            String[] commandLine = command.split(" <:> ");
            String name = commandLine[0];
            String hatColour = commandLine[1];
            int physics = Integer.parseInt(commandLine[2]);


            List<String> mapKey = Arrays.asList(hatColour, name);
            dwarves.putIfAbsent(mapKey, physics);


            if (dwarves.get(mapKey) < physics) {
                dwarves.put(mapKey, physics);
            }



            command = scanner.nextLine();
        }


        Map<String, Integer> repetitionsMap = new HashMap<>();

        for (List<String> mapKey : dwarves.keySet()) {
            String hatColor = mapKey.get(0);
            repetitionsMap.putIfAbsent(hatColor, 0);
            repetitionsMap.put(hatColor, repetitionsMap.get(hatColor) +1);
        }


        dwarves.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<List<String>, Integer>comparingByValue().reversed()
                                .thenComparing(entry -> repetitionsMap.get(entry.getKey().get(0)) * -1)
                )
                .forEach(SnowWhite::print);


    }

    private static void print(Map.Entry<List<String>, Integer> entry) {
        System.out.printf("(%s) %s <-> %d%n", entry.getKey().get(0), entry.getKey().get(1), entry.getValue());
    }
}
