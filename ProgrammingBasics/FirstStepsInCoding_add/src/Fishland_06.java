import java.util.Scanner;

public class Fishland_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceMackerel = Double.parseDouble(scanner.nextLine());
        double priceToy = Double.parseDouble(scanner.nextLine());
        double kilogramsBonito = Double.parseDouble(scanner.nextLine());
        double kilogramsHorseMackerel = Double.parseDouble(scanner.nextLine());
        int kilogramsShells = Integer.parseInt(scanner.nextLine());

        double priceBonito = priceMackerel + (priceMackerel * 0.6);
        double priceHorseMackerel = priceToy + (priceToy * 0.8);

        double totalPriceBonito = kilogramsBonito * priceBonito;
        double totalPriceHorseMackerel = kilogramsHorseMackerel * priceHorseMackerel;
        double totalPriceShells = kilogramsShells * 7.50;

        double result = totalPriceBonito + totalPriceHorseMackerel + totalPriceShells;
        System.out.printf("%.2f", result);
    }
}
