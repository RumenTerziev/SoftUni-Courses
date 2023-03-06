import java.util.Scanner;

public class GoldMine_0602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countLocations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countLocations; i++) {
            double averageGoldNeeded = Double.parseDouble(scanner.nextLine());
            int daysPerLocation = Integer.parseInt(scanner.nextLine());


            double sumGoldPerLocation = 0;
            double averageGold = 0;
            boolean isReached = false;
            for (int days = 1; days <= daysPerLocation; days++) {
                double goldMined = Double.parseDouble(scanner.nextLine());
                sumGoldPerLocation = sumGoldPerLocation + goldMined;
            }
            averageGold = sumGoldPerLocation / daysPerLocation;
            if (averageGold >= averageGoldNeeded) {
                isReached = true;
            }
            if (isReached) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageGold);
            } else {
                System.out.printf("You need %.2f gold.%n", averageGoldNeeded - averageGold);
            }
        }
    }
}
