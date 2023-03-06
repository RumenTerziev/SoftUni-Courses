import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double totalMoney = 0;

        for (int i = 1; i <= lostGamesCount; i++) {
            if (i % 12 == 0) {
                totalMoney = totalMoney + headsetPrice + mousePrice + keyboardPrice + displayPrice;
            } else if (i % 6 == 0) {
                totalMoney = totalMoney + headsetPrice + mousePrice + keyboardPrice;
            } else if (i % 3 == 0) {
                totalMoney = totalMoney + mousePrice;
            } else if (i % 2 == 0) {
                totalMoney = totalMoney + headsetPrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", totalMoney);
    }
}
