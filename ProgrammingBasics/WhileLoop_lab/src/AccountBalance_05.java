import java.util.Scanner;

public class AccountBalance_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        double sum = 0;
        while (!command.equals("NoMoreMoney")) {
            double currentDeposit = Double.parseDouble(command);
            if (currentDeposit < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", currentDeposit);
            }
            sum = sum + currentDeposit;
            command = scanner.nextLine();
        }

        System.out.printf("Total: %.2f%n", sum);
    }
}
