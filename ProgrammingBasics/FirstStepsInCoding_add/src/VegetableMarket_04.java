import java.util.Scanner;

public class VegetableMarket_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vegetablesPrice = Double.parseDouble(scanner.nextLine());
        double fruitsPrice = Double.parseDouble(scanner.nextLine());
        int vegetablesKilograms = Integer.parseInt(scanner.nextLine());
        int fruitsKilograms = Integer.parseInt(scanner.nextLine());
        double income = (vegetablesPrice * vegetablesKilograms) + (fruitsPrice * fruitsKilograms);
        double result = income / 1.94;
        System.out.printf("%.2f",result);
    }
}
