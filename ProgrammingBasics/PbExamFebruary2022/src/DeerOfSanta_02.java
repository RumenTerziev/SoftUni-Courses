import java.util.Scanner;

public class DeerOfSanta_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());
        int totalFood = Integer.parseInt(scanner.nextLine());
        double foodPerDayFirstDeer = Double.parseDouble(scanner.nextLine());
        double foodPerDaySecondDeer = Double.parseDouble(scanner.nextLine());
        double foodPerDayThirdDeer = Double.parseDouble(scanner.nextLine());

        double totalFoodDeerOne = foodPerDayFirstDeer * daysOff;
        double totalFoodDeerTwo = foodPerDaySecondDeer * daysOff;
        double totalFoodDeerThree = foodPerDayThirdDeer * daysOff;
        double allNeededFood = totalFoodDeerOne + totalFoodDeerTwo + totalFoodDeerThree;


        if (totalFood >= allNeededFood) {
            double foodLeft = totalFood - allNeededFood;
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft));
        } else {
            double foodNeeded = allNeededFood - totalFood;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded));
        }
    }
}
