package regularExpressionsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        List<String> furnitureList = new ArrayList<>();
        double sum = 0;
        while (!input.equals("Purchase")) {


            Pattern pattern = Pattern.compile(">>(?<type>\\w+)<<(?<price>\\d+[.]*[0-9]*)!(?<quantity>[0-9]+)");
            Matcher furniture = pattern.matcher(input);

            while (furniture.find()) {
                String type = furniture.group("type");
                double price = Double.parseDouble(furniture.group("price"));
                int quantity = Integer.parseInt(furniture.group("quantity"));
                furnitureList.add(type);

                sum += price * quantity;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");

        for (String furniture : furnitureList) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
