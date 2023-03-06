import java.util.Scanner;

public class Bills_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        double totalElectricityBill = 0;
        double totalWaterBill = 0;
        double totalInternetBill = 0;
        double totalOthers = 0;
        double average = 0;
        for (int i = 1; i <= period; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());

            double waterBill = 20;
            double internetBill = 15;
            double others = (electricityBill + waterBill + internetBill) + ((electricityBill + waterBill + internetBill) *
                    0.2);

            totalElectricityBill = totalElectricityBill + electricityBill;
            totalWaterBill = totalWaterBill + waterBill;
            totalInternetBill = totalInternetBill + internetBill;
            totalOthers = totalOthers + others;
        }
        average = (totalElectricityBill + totalWaterBill + totalInternetBill + totalOthers) / period;

        System.out.printf("Electricity: %.2f lv%n", totalElectricityBill);
        System.out.printf("Water: %.2f lv%n", totalWaterBill);
        System.out.printf("Internet: %.2f lv%n", totalInternetBill);
        System.out.printf("Other: %.2f lv%n", totalOthers);
        System.out.printf("Average: %.2f lv%n", average);
    }
}
