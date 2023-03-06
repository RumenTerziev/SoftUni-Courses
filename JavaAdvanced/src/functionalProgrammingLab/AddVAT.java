package functionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> pricesWithVAT = d -> d + (d * 0.2);

        System.out.println("Prices with VAT:");
        Arrays.stream(prices).forEach(d -> {
            System.out.printf("%.2f%n", pricesWithVAT.apply(d));
        });

    }
}
