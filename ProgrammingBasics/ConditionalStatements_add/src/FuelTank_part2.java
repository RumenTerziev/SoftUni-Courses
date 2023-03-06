import java.util.Scanner;

public class FuelTank_part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfFuel = scanner.nextLine();
        double litersFuel = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();
        boolean isValid = false;
        double price = 0;
        double totalPrice = 0;
        if (clubCard.equals("Yes")) {
            isValid = true;}

        if (typeOfFuel.equals("Gas")) {
                price = 0.93;
                if (isValid) {
                    price = price - 0.08;
                }
                totalPrice = litersFuel * price;
        } else if (typeOfFuel.equals("Gasoline")) {
                price = 2.22;
                if (isValid) {
                    price = price - 0.18;
                }
                totalPrice = litersFuel * price;
        } else if (typeOfFuel.equals("Diesel")) {
                price = 2.33;
                if (isValid) {
                    price = price - 0.12;
                }
                totalPrice = litersFuel * price;
        }
        if (litersFuel < 20) {
            System.out.printf("%.2f lv.",totalPrice);
        } else if (litersFuel <= 25) {
            totalPrice = totalPrice - (totalPrice * 0.08);
            System.out.printf("%.2f lv.",totalPrice);
        }
        else {
            totalPrice = totalPrice - (totalPrice * 0.10);
            System.out.printf("%.2f lv.",totalPrice);
        }
    }
}
