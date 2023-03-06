import java.util.Scanner;

public class Workout_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double initialKilometers = Double.parseDouble(scanner.nextLine());


        boolean hasSucceed = false;
        int i = 1;
        double totalKilometers = initialKilometers;
        double sumTotal = initialKilometers;
        while (i <= days) {
            double addKilometers = Double.parseDouble(scanner.nextLine());
            totalKilometers = totalKilometers + (totalKilometers * (addKilometers * 0.01));
            sumTotal = sumTotal + totalKilometers;


            i++;
        }

        if (sumTotal >= 1000) {
            double moreKilometers = sumTotal - 1000;
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(moreKilometers));
        } else {
            double kilometersNeeded = 1000 - sumTotal;
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(kilometersNeeded));
        }

    }
}
