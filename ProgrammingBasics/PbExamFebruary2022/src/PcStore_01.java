import java.util.Scanner;

public class PcStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double processorDollars = Double.parseDouble(scanner.nextLine());
        double videoCardDollars = Double.parseDouble(scanner.nextLine());
        double ramDollars = Double.parseDouble(scanner.nextLine());
        int countRam = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        double processorBgn = processorDollars * 1.57;
        double videoCardBgn = videoCardDollars * 1.57;
        double ramBgn = ramDollars * 1.57;

        double totalPrice = (processorBgn - (processorBgn * discount)) + (videoCardBgn - (videoCardBgn * discount))
                + (countRam * ramBgn);

        System.out.printf("Money needed - %.2f leva.", totalPrice);
    }
}
