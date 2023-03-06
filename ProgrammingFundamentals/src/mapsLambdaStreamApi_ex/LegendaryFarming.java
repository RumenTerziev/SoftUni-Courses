package mapsLambdaStreamApi_ex;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.putIfAbsent("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        Map<String, Integer> junk = new LinkedHashMap<>();
        String input = scanner.nextLine();

        int shards = 0;
        int fragments = 0;
        int motes = 0;


        boolean isWin = false;
        while (true) {

            String[] materialsFarmed = input.split(" ");

            for (int i = 0; i <= materialsFarmed.length - 1; i += 2) {
                int quantity = Integer.parseInt(materialsFarmed[i]);
                String resource = materialsFarmed[i + 1].toLowerCase();

                if (resource.equals("shards")) {
                    shards = shards + quantity;

                    items.put(resource, shards);

                    if (shards >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        shards = shards - 250;
                        items.put(resource, shards);
                        isWin = true;
                        break;
                    }
                } else if (resource.equals("fragments")) {
                    fragments = fragments + quantity;

                    items.put(resource, fragments);

                    if (fragments >= 250) {
                        System.out.println("Valanyr obtained!");
                        fragments = fragments - 250;
                        items.put(resource, fragments);
                        isWin = true;
                        break;
                    }
                } else if (resource.equals("motes")) {
                    motes = motes + quantity;

                    items.put(resource, motes);

                    if (motes >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        motes = motes - 250;
                        items.put(resource, motes);
                        isWin = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(resource, 0);
                    junk.put(resource, junk.get(resource) + quantity);

                }
            }


            if (isWin) {
                break;
            }

            input = scanner.nextLine();
        }


        items.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }
}
