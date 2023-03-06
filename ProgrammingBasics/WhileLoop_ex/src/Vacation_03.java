import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());


        int countDays = 0;
        int spendingDays = 0;
        double totalMoney = availableMoney;
        boolean isFailed = false;
        while (totalMoney < neededMoney) {
            String action = scanner.nextLine();
            double currentMoney = Double.parseDouble(scanner.nextLine());
            if (action.equals("spend")) {
                totalMoney = totalMoney - currentMoney;
                if (totalMoney < 0) {
                    totalMoney = 0;
                }
                countDays++;
                spendingDays++;
                }
             else if (action.equals("save")) {
                totalMoney = totalMoney + currentMoney;
                countDays++;
                spendingDays = 0;
            }
             if (spendingDays == 5) {
                 isFailed = true;
                 break;
             }
        }
        if (isFailed) {
            System.out.printf("You can't save the money.%n%d", countDays);
        } else {
            System.out.printf("You saved the money for %d days.", countDays);
        }
    }
}
