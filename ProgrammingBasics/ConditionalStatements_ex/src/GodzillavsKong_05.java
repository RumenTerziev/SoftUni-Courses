import java.util.Scanner;

public class GodzillavsKong_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double funds = Double.parseDouble(scanner.nextLine());
        int numStatists = Integer.parseInt(scanner.nextLine());
        double priceCostume = Double.parseDouble(scanner.nextLine());

        double decor = funds * 0.10;
        double statistsCostumesTotalCost = numStatists * priceCostume;

        if (numStatists > 150) {
            double discount = statistsCostumesTotalCost * 0.10;
            statistsCostumesTotalCost = statistsCostumesTotalCost - discount;
        }
        double moneyNeeded = decor + statistsCostumesTotalCost;
        double diff = Math.abs(moneyNeeded - funds);
        if (moneyNeeded <= funds) {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", diff);
        }
    }
}
