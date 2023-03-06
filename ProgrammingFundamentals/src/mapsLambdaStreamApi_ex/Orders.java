package mapsLambdaStreamApi_ex;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> products = new LinkedHashMap<>();
        Map<String, Double> prices = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("buy")) {

            String[] commandLine = command.split(" ");
            String typeOfProduct = commandLine[0];
            double price = Double.parseDouble(commandLine[1]);
            int quantity = Integer.parseInt(commandLine[2]);

            prices.put(typeOfProduct, price);

            if (!products.containsKey(typeOfProduct)) {
                products.put(typeOfProduct, quantity);
            } else {
                products.put(typeOfProduct, products.get(typeOfProduct) + quantity);
            }


            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : prices.entrySet()) {

            String product = entry.getKey();
            double finalSum = entry.getValue() * products.get(product);
            System.out.printf("%s -> %.2f%n", product, finalSum);
        }
    }
}
