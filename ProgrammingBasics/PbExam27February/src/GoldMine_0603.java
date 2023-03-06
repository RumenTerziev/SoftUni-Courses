import java.util.Scanner;

public class GoldMine_0603 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locationCount = Integer.parseInt(scanner.nextLine());
        boolean isReached = false;
        for (int i = 1; i <= locationCount; i++) {
            double averageGoldPerLocation = Double.parseDouble(scanner.nextLine());
            int countDays = Integer.parseInt(scanner.nextLine());


            double sumGold = 0;
            double averageGold = 0;
            for (int j = 1; j <= countDays; j++) {
                double currentDayGold = Double.parseDouble(scanner.nextLine());
                sumGold = sumGold + currentDayGold;
                averageGold = sumGold / countDays;
            }


            double diff = Math.abs(averageGoldPerLocation - averageGold);
            if (averageGold >= averageGoldPerLocation) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageGold);
            } else {
                System.out.printf("You need %.2f gold.%n", diff);
            }
        }
    }
}
