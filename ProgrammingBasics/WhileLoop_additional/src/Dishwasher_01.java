import java.util.Scanner;

public class Dishwasher_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBottlesDetergent = Integer.parseInt(scanner.nextLine());
        double quantity = countBottlesDetergent * 750;

        String command = scanner.nextLine();
        int numLoading = 0;
        double leftover = quantity;
        int totalDishes = 0;
        int totalPots = 0;
        while (!command.equals("End")) {
            int countDishes = Integer.parseInt(command);
            numLoading++;

            if (numLoading % 3 == 0) {
                leftover = leftover - countDishes * 15;
                totalPots = totalPots + countDishes;
            } else {
                leftover = leftover - countDishes * 5;
                totalDishes = totalDishes + countDishes;
            }
            if (leftover < 0) {
                break;
            }

            command = scanner.nextLine();
        }
        if (leftover >= 0) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", totalDishes, totalPots);
            System.out.printf("Leftover detergent %.0f ml.", leftover);
        } else {
            System.out.printf("Not enough detergent, %.0f ml. more necessary!", Math.abs(leftover));
        }
    }
}
