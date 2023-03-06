import java.util.Scanner;

public class Coins_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tape = Double.parseDouble(scanner.nextLine());

        double coinsTape = tape * 100;


        int countCoins = 0;
        while (coinsTape > 0) {

            if (coinsTape >= 200) {
                coinsTape = coinsTape - 200;
                countCoins++;
            } else if (coinsTape >= 100) {
                coinsTape = coinsTape - 100;
                countCoins++;
            } else if (coinsTape >= 50) {
                coinsTape = coinsTape - 50;
                countCoins++;
            } else if (coinsTape >= 20) {
                coinsTape = coinsTape - 20;
                countCoins++;
            } else if (coinsTape >= 10) {
                coinsTape = coinsTape - 10;
                countCoins++;
            } else if (coinsTape >= 5) {
                coinsTape = coinsTape - 5;
                countCoins++;
            } else if (coinsTape >= 2) {
                coinsTape = coinsTape - 2;
                countCoins++;
            } else if (coinsTape >= 1) {
                coinsTape = coinsTape - 1;
                countCoins++;
            } else {
                break;
            }
        }
        System.out.println(countCoins);

    }
}
