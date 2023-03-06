package setsAndMapsAdvancedExercises;

import java.util.*;

public class DragonArmyAdv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<Double>>> dragonTypeMap = new LinkedHashMap<>();

        for (int i = 0; i < countOfCommands; i++) {

            String[] inputData = scanner.nextLine().split("\\s+");
            String dragonType = inputData[0];
            String dragonName = inputData[1];
            String damageString = inputData[2];
            String healthString = inputData[3];
            String armorString = inputData[4];

            double damage = 45;
            double health = 250;
            double armor = 10;
            if (!damageString.equals("null")) {
                damage = Integer.parseInt(damageString);
            }
            if (!healthString.equals("null")) {
                health = Integer.parseInt(healthString);
            }
            if (!armorString.equals("null")) {
                armor = Integer.parseInt(armorString);
            }

            List<Double> stats = Arrays.asList(damage, health, armor);

            dragonTypeMap.putIfAbsent(dragonType, new TreeMap<>());

            dragonTypeMap.get(dragonType).put(dragonName, stats);


        }


        for (var entry : dragonTypeMap.entrySet()) {
            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmor = 0;
            for (var stringListEntry : entry.getValue().entrySet()) {
                sumDamage += stringListEntry.getValue().get(0);
                sumHealth += stringListEntry.getValue().get(1);
                sumArmor += stringListEntry.getValue().get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), sumDamage / entry.getValue().size(), sumHealth / entry.getValue().size(), sumArmor / entry.getValue().size());

            for (var stringListEntry : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", stringListEntry.getKey(), stringListEntry.getValue().get(0), stringListEntry.getValue().get(1)
                        , stringListEntry.getValue().get(2));
            }
        }
    }
}
