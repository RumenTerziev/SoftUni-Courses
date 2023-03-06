import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double totalMoney = 0;
        double price = 0;
        String command = scanner.nextLine();
        while (!command.equals("Start")) {
            double insertedMoney = Double.parseDouble(command);


            if (insertedMoney == 0.1 || insertedMoney == 0.2 || insertedMoney == 0.5
                    || insertedMoney == 1.0 || insertedMoney == 2.0) {
                totalMoney = totalMoney + insertedMoney;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedMoney);
            }
            command = scanner.nextLine();

        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.printf("Invalid product%n");
                    input = scanner.nextLine();
                    continue;
            }
            if (totalMoney >= price) {
                System.out.printf("Purchased %s%n", input);
                totalMoney = totalMoney - price;
            } else {
                System.out.printf("Sorry, not enough money%n");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", totalMoney);
    }
}