import java.util.Scanner;

public class Harvest_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int area = Integer.parseInt(scanner.nextLine());
        double kilogramsPerSquareMeter = Double.parseDouble(scanner.nextLine());
        int litersNeeded = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());

        double harvest = area * kilogramsPerSquareMeter;
        double harvestForWine = harvest * 0.4;
        double litersWine = harvestForWine / 2.5;
        double difference = Math.abs(litersWine - litersNeeded);
        if (litersWine >= litersNeeded) {
            double litersPerWorker = difference / workersCount;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.\n" +
                            "%.0f liters left -> %.0f liters per person.",
                    Math.floor(litersWine), Math.ceil(difference), Math.ceil(litersPerWorker));

        } else {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(difference));
        }

    }
}
