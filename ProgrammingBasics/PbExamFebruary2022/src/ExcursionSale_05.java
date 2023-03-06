import java.util.Scanner;

public class ExcursionSale_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countSeaPackages = Integer.parseInt(scanner.nextLine());
        int countMountainPackages = Integer.parseInt(scanner.nextLine());


        int seaPackage = 0;
        int mountainPackage = 0;
        int seaPrice = 0;
        int mountainPrice = 0;
        int seaIncome = 0;
        int mountainIncome = 0;
        double totalSum = 0;
        boolean isSold = false;
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
        String typeOfExcursion = command;
            switch (typeOfExcursion) {
                case "sea":
                    seaPackage++;
                    break;
                case "mountain":
                    mountainPackage++;
                    break;
            }
        if (seaPackage <= countSeaPackages) {
            seaPrice = 680;
        } else {
            seaPrice = 0;
        }
            if (mountainPackage <= countMountainPackages) {
                mountainPrice = 499;
            } else {
                mountainPrice = 0;
            }

            seaIncome = seaIncome + seaPrice;
            mountainIncome = mountainIncome + mountainPrice;
            totalSum = seaIncome + mountainIncome;
            if (seaPackage >= countSeaPackages && mountainPackage >= countMountainPackages) {
                isSold = true;
                break;
            }
        command = scanner.nextLine();
        }

            if (isSold) {
                System.out.printf("Good job! Everything is sold.%n");
            }
        System.out.printf("Profit: %.0f leva.",totalSum);
    }
}
