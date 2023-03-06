import java.util.Scanner;

public class Logistics_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCargo = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double totalWeight = 0;
        int microBusWeight = 0;
        int truckWeight = 0;
        int trainWeight = 0;
        double microBusPercent = 0;
        double truckPercent = 0;
        double trainPercent = 0;
        double totalPrice = 0;
        double averagePrice = 0;
        for (int i = 1; i <= countCargo; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            if (cargoWeight <= 3) {
                price = 200;
                microBusWeight = microBusWeight + cargoWeight;
            } else if (cargoWeight <= 11) {
                price = 175;
                truckWeight = truckWeight + cargoWeight;
            } else {
                price = 120;
                trainWeight = trainWeight + cargoWeight;
            }
            totalWeight = totalWeight + cargoWeight;
            totalPrice = totalPrice + (cargoWeight * price);
        }
        microBusPercent = microBusWeight / totalWeight * 100;
        truckPercent = truckWeight / totalWeight * 100;
        trainPercent = trainWeight / totalWeight * 100;
        averagePrice = totalPrice / totalWeight;

        System.out.printf("%.2f%n", averagePrice);
        System.out.printf("%.2f%%%n", microBusPercent);
        System.out.printf("%.2f%%%n", truckPercent);
        System.out.printf("%.2f%%", trainPercent);
    }
}
