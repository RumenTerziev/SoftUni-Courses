import java.util.Scanner;

public class ProgrammingBook_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerList = Double.parseDouble(scanner.nextLine());
        double pricePerCover = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());
        double designerSum = Double.parseDouble(scanner.nextLine());
        int percentPayedByGroup = Integer.parseInt(scanner.nextLine());

        double sumForBook = (pricePerList * 899) + (pricePerCover * 2);
        double sumAfterDiscount = sumForBook - ((discountPercent * 0.01) * sumForBook);
        double totalPrice = sumAfterDiscount + designerSum;
        double priceLeftToPay = totalPrice - ((percentPayedByGroup * 0.01) * totalPrice);

        System.out.printf("Avtonom should pay %.2f BGN.", priceLeftToPay);

    }
}
