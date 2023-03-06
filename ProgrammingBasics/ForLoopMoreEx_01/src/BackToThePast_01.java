import java.util.Scanner;

public class BackToThePast_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int yearsToReach = Integer.parseInt(scanner.nextLine());


        double moneyLeft = heritage;
        int age = 18;
        for (int i = 1800; i <= yearsToReach; i++) {

            if (i % 2 == 0) {
                moneyLeft = moneyLeft - 12000;
            } else {
                moneyLeft = moneyLeft - (12000 + age * 50);
            }
            age++;
        }


        if (moneyLeft >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(moneyLeft));
        }
    }
}
