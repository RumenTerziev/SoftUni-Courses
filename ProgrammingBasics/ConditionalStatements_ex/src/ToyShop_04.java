import java.util.Scanner;

public class ToyShop_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int teddiesCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = 2.60;
        double dollPrice = 3.0;
        double teddyPrice = 4.10;
        double minionPrice = 8.20;
        double truckPrice = 2.0;

        double totalMoney = (puzzlesCount * puzzlePrice) + (dollsCount * dollPrice) + (teddiesCount * teddyPrice)
                + (minionsCount * minionPrice) + (trucksCount * truckPrice);

        double allToys = puzzlesCount + dollsCount + teddiesCount + minionsCount + trucksCount;

        if (allToys >= 50) {
            double discount = totalMoney * 0.25;
            totalMoney = totalMoney - discount;
        }
        double rent = totalMoney * 0.10;

        double finalMoney = totalMoney - rent;
        double diff = Math.abs(finalMoney - tripPrice);
        if (finalMoney >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);
        }
    }
}

