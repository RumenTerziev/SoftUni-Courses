import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sweet = scanner.nextLine();
        int countSweets = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());

        double orderPrice = 0;
        double pricePerPiece = 0;
        if (day <= 15) {
            switch (sweet) {
                case "Cake":
                    pricePerPiece = 24;
                    break;
                case "Souffle":
                    pricePerPiece = 6.66;
                    break;
                case "Baklava":
                    pricePerPiece = 12.60;
                    break;
            }
        } else {
            switch (sweet) {
                case "Cake":
                    pricePerPiece = 28.70;
                    break;
                case "Souffle":
                    pricePerPiece = 9.80;
                    break;
                case "Baklava":
                    pricePerPiece = 16.98;
                    break;
            }
        }
        orderPrice = countSweets * pricePerPiece;
        if (day <= 22) {
            if (orderPrice >= 100 && orderPrice <= 200) {
                orderPrice = orderPrice - (orderPrice * 0.15);
            } else if (orderPrice > 200) {
                orderPrice = orderPrice - (orderPrice * 0.25);
            }
            if (day <= 15) {
                orderPrice = orderPrice - (orderPrice * 0.10);
            }
        }
        System.out.printf("%.2f", orderPrice);
    }
}
