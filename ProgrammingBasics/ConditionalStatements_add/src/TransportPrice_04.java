import java.util.Scanner;

public class TransportPrice_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kilometers = Integer.parseInt(scanner.nextLine());
        String timeOfTheDay = scanner.nextLine();
        double totalPrice = 0;
        double tariffTaxi = 0;
        if (kilometers < 20) {
            if ("day".equals(timeOfTheDay)) {
                tariffTaxi = 0.79;
            } else if ("night".equals(timeOfTheDay)) {
                tariffTaxi = 0.90;
            } else {
                System.out.println("error");
            }
                    totalPrice = kilometers * tariffTaxi + 0.70;

        } else if (kilometers < 100) {
            totalPrice = kilometers * 0.09;
        } else {
            totalPrice = kilometers * 0.06;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
