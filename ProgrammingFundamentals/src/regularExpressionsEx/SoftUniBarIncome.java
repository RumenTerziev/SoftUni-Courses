package regularExpressionsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();


        double totalSum = 0;
        while (!input.equals("end of shift")) {

            Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]*)%[^\\|\\$%.]*<(?<product>[\\w]+)>[^\\|\\$%.]*\\|(?<quantity>[0-9]+)\\|[^\\|\\$%.]*?(?<price>[0-9]+(.?[0-9])*)\\$");
            Matcher validInput = pattern.matcher(input);


            if (validInput.find()) {

                String name = validInput.group("name");
                String product = validInput.group("product");
                int quantity = Integer.parseInt(validInput.group("quantity"));
                double price = Double.parseDouble(validInput.group("price"));


                double allPrice = quantity * price;


                totalSum = totalSum + allPrice;
                System.out.printf("%s: %s - %.2f%n", name, product, allPrice);

            }


            input = scanner.nextLine();

        }

        System.out.printf("Total income: %.2f", totalSum);

    }
}
