import java.util.Scanner;

public class GoldMine_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locationCount = Integer.parseInt(scanner.nextLine());

        boolean isReached = false;
        double averageGold = 0;
        for (int i = 1; i <= locationCount; i++) {
            double averageGoldPerDay = Double.parseDouble(scanner.nextLine());
            int daysPerLocation = Integer.parseInt(scanner.nextLine());
            double sumGoldPerLocation = 0;
            for (int j = 1; j <= daysPerLocation; j++) {
                double goldObtainedPerDay = Double.parseDouble(scanner.nextLine());
               sumGoldPerLocation  = sumGoldPerLocation + goldObtainedPerDay;
            }
            if (averageGold >= averageGoldPerDay) {
                isReached = true;
            }
            double diff = Math.abs(averageGoldPerDay - averageGold);
            if (isReached) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageGold);
            } else {
                System.out.printf("You need %.2f gold.%n", diff);
            }

        }
    }
}
