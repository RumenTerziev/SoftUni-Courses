package mapsLambdaStreamApiMoreEx;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<Double>>> dragonsMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {

            String[] input = scanner.nextLine().split(" ");
            String dragonType = input[0];
            String dragonName = input[1];
            double damage = 45;
            double health = 250;
            double armour = 10;

            if (!input[2].equals("null")) {
                damage = Double.parseDouble(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Double.parseDouble(input[3]);
            }
            if (!input[4].equals("null")) {
                armour = Double.parseDouble(input[4]);
            }

            dragonsMap.putIfAbsent(dragonType, new TreeMap<>());
            List<Double> dragonStats = Arrays.asList(damage, health, armour);
            dragonsMap.get(dragonType).put(dragonName, dragonStats);

        }

        for (Map.Entry<String, Map<String, List<Double>>> entry : dragonsMap.entrySet()) {
            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmour = 0;
            for (Map.Entry<String, List<Double>> stringListEntry : entry.getValue().entrySet()) {
                sumDamage = sumDamage + stringListEntry.getValue().get(0);
                sumHealth = sumHealth + stringListEntry.getValue().get(1);
                sumArmour = sumArmour + stringListEntry.getValue().get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), sumDamage / entry.getValue().size(), sumHealth / entry.getValue().size(), sumArmour / entry.getValue().size());
            for (Map.Entry<String, List<Double>> secondEntry : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                        secondEntry.getKey(), secondEntry.getValue().get(0), secondEntry.getValue().get(1), secondEntry.getValue().get(2));
            }
        }
    }
}