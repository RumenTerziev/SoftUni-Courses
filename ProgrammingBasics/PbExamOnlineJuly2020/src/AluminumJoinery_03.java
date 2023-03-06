import java.util.Scanner;

public class AluminumJoinery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countJoinery = Integer.parseInt(scanner.nextLine());
        String typeJoinery = scanner.nextLine();
        String delivery = scanner.nextLine();

        if (countJoinery < 10) {
            System.out.println("Invalid order");
        } else {

            double price = 0;
            double totalPrice = 0;

            switch (typeJoinery) {
                case "90X130":
                    price = countJoinery * 110;
                    if (countJoinery >= 30 && countJoinery < 60) {
                        price = price - (price * 0.05);
                    } else if (countJoinery >= 60) {
                        price = price - (price * 0.08);
                    }
                    break;
                case "100X150":
                    price = countJoinery * 140;
                    if (countJoinery >= 40 && countJoinery < 80) {
                        price = price - (price * 0.06);
                    } else if (countJoinery >= 80) {
                        price = price - (price * 0.10);
                    }
                    break;
                case "130X180":
                    price = countJoinery * 190;
                    if (countJoinery >= 20 && countJoinery < 50) {
                        price = price - (price * 0.07);
                    } else if (countJoinery >= 50) {
                        price = price - (price * 0.12);
                    }
                    break;
                case "200X300":
                    price = countJoinery * 250;
                    if (countJoinery >= 25 && countJoinery < 50) {
                        price = price - (price * 0.09);
                    } else if (countJoinery >= 50) {
                        price = price - (price * 0.14);
                    }
                    break;
            }
            if (delivery.equals("With delivery")) {
                totalPrice = price + 60;
            } else if (delivery.equals("Without delivery")) {
                totalPrice = price;
            }
            if (countJoinery > 99) {
                totalPrice = totalPrice - (totalPrice * 0.04);
            }
            System.out.printf("%.2f BGN", totalPrice);
        }

    }
}