import java.util.Scanner;

public class Shopping_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double funds = Double.parseDouble(scanner.nextLine());
        int numVideoCards = Integer.parseInt(scanner.nextLine());
        int numProcessors = Integer.parseInt(scanner.nextLine());
        int numRam = Integer.parseInt(scanner.nextLine());

        double videoCardTotalPrice = numVideoCards * 250;
        double processorPrice = videoCardTotalPrice * 0.35;
        double ramPrice = videoCardTotalPrice * 0.10;

        double processorsTotalPrice = numProcessors * processorPrice;
        double ramTotalPrice = numRam * ramPrice;
        double moneyNeeded = videoCardTotalPrice + processorsTotalPrice + ramTotalPrice;
        if (numVideoCards > numProcessors) {
            double discount = moneyNeeded * 0.15;
            moneyNeeded = moneyNeeded - discount;
        }
        double diff = Math.abs(moneyNeeded - funds);
        if (moneyNeeded <= funds) {
            System.out.printf("You have %.2f leva left!", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }

    }
}
