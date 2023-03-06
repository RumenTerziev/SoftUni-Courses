import java.util.Scanner;

public class FuelTank_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfFuel = scanner.nextLine();
        double litersFuel = Double.parseDouble(scanner.nextLine());

        switch (typeOfFuel) {
            case "Diesel":
                if (litersFuel < 25) {
                    System.out.println("Fill your tank with diesel!");
                } else {
                    System.out.println("You have enough diesel.");
                }
                break;
            case "Gasoline":
                if (litersFuel < 25) {
                    System.out.println("Fill your tank with gasoline!");
                } else {
                    System.out.println("You have enough gasoline.");
                }
                break;
            case "Gas":
                if (litersFuel < 25) {
                    System.out.println("Fill your tank with gas!");
                } else {
                    System.out.println("You have enough gas.");
                }
                break;
            default:
                System.out.println("Invalid fuel!");
                break;
        }
    }
}
