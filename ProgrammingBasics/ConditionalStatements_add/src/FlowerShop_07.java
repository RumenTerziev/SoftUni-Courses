import java.util.Scanner;

public class FlowerShop_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double moneyForGift = Double.parseDouble(scanner.nextLine());

        double magnoliasPrice = magnolias * 3.25;
        double hyacinthsPrice = hyacinths * 4.0;
        double rosesPrice = roses * 3.50;
        double cactusPrice = cactus * 8;
        double totalPrice = magnoliasPrice + hyacinthsPrice + rosesPrice + cactusPrice;
        double tax = totalPrice * 0.05;
        double finaPrice = totalPrice - tax;

        double diff = Math.abs(moneyForGift - finaPrice);
        if (finaPrice >= moneyForGift) {
            System.out.printf("She is left with %.0f leva.", Math.floor(diff));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(diff));
        }
    }
}
