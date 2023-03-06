import java.util.Scanner;

public class AddBags_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double aboveTwenty = Double.parseDouble(scanner.nextLine());
        double bagKilograms = Double.parseDouble(scanner.nextLine());
        int daysToTrip = Integer.parseInt(scanner.nextLine());
        int bagsCount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double addPrice = 0;

        if (bagKilograms < 10) {
            price = aboveTwenty * 0.2;
        } else if (bagKilograms <= 20) {
            price = aboveTwenty * 0.50;
        } else {
            price = aboveTwenty;
        }
        if (daysToTrip < 7) {
            addPrice = price * 0.40;
        } else if (daysToTrip <= 30) {
            addPrice = price * 0.15;
        } else {
            addPrice = price * 0.10;
        }
        double totalPrice = price + addPrice;
        double result = bagsCount * totalPrice;
        System.out.printf("The total price of bags is: %.2f lv.", result);
    }
}
