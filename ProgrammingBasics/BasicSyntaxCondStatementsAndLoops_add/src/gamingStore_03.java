import java.util.Scanner;

public class gamingStore_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialMoney = Double.parseDouble(scanner.nextLine());

        boolean isOutOfMoney = false;
        double moneyLeft = initialMoney;
        double gamePrice = 0;
        String command = scanner.nextLine();
        while (!command.equals("Game Time")) {
            String gameName = command;
            switch (gameName) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    command = scanner.nextLine();
                    continue;
            }
            if (moneyLeft - gamePrice > 0) {
                moneyLeft = moneyLeft - gamePrice;
                System.out.printf("Bought %s%n", gameName);
            } else if (moneyLeft - gamePrice == 0) {
                moneyLeft = moneyLeft - gamePrice;
                System.out.printf("Bought %s%n", gameName);
                System.out.println("Out of money!");
                isOutOfMoney = true;
                break;
            } else {
                System.out.println("Too Expensive");
            }
            if (moneyLeft <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (!isOutOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", initialMoney - moneyLeft, moneyLeft);
        }
    }
}
