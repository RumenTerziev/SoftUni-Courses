package mapsLambdaStreamApi_ex;

import java.util.*;
import java.util.stream.Collectors;

public class asd {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int quantity = 0;
            String type = "";
            String find = "";

            Map<String, Integer> materials = new LinkedHashMap<>();

            String shards = "shards";
            String fragments = "fragments";
            String motes = "motes";

            materials.put(shards, quantity);
            materials.put(fragments, quantity);
            materials.put(motes, quantity);

            Map<String, Integer> junks = new LinkedHashMap<>();

            String input = scanner.nextLine().toLowerCase();

            List<String> listItems = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            boolean isFind = false;

            while (!isFind) {

                for (int i = 0; i < listItems.size(); i++) {

                    if (i == 0) {

                        quantity = Integer.parseInt(listItems.get(0));

                        type = listItems.get(1).toLowerCase(Locale.ROOT);

                        if (type.equals("shards") || type.equals("fragments") || type.equals("motes")) {

                            materials.put(type, materials.get(type) + quantity);

                            if (materials.get(type) >= 250) {

                                if (type.equals("shards")) {
                                    find = "Shadowmourne";
                                } else if (type.equals("fragments")) {
                                    find = "Valanyr";
                                } else {
                                    find = "Dragonwrath";
                                }

                                quantity = materials.get(type) - 250;

                                materials.put(type, quantity);

                                isFind = true;
                                break;
                            }

                        } else {

                            junks.put(type, quantity);

                        }
                    } else if (i % 2 != 0 && i != 1) {

                        quantity = Integer.parseInt(listItems.get(i - 1));

                        type = listItems.get(i).toLowerCase(Locale.ROOT);

                        if (type.equals("shards") || type.equals("fragments") || type.equals("motes")) {

                            materials.put(type, materials.get(type) + quantity);

                            if (materials.get(type) >= 250) {

                                if (type.equals("shards")) {
                                    find = "Shadowmourne";
                                } else if (type.equals("fragments")) {
                                    find = "Valanyr";
                                } else {
                                    find = "Dragonwrath";
                                }

                                quantity = materials.get(type) - 250;

                                materials.put(type, quantity);

                                isFind = true;
                                break;
                            }

                        } else if (junks.containsKey(type)) {

                            junks.put(type, junks.get(type) + quantity);

                        } else {
                            junks.put(type, quantity);
                        }

                    }
                }

                if (!isFind) {
                    input = scanner.nextLine();
                    listItems = Arrays.stream(input.split(" ")).collect(Collectors.toList());

                } else {

                    System.out.printf("%s obtained!%n", find);


                    for (Map.Entry<String, Integer> entryMaterials : materials.entrySet()) {


                        System.out.println(entryMaterials.getKey() + ": " + entryMaterials.getValue());


                    }

                    for (Map.Entry<String, Integer> entryJunk : junks.entrySet()) {

                        System.out.println(entryJunk.getKey() + ": " + entryJunk.getValue());

                    }

                }
            }
        }
}
