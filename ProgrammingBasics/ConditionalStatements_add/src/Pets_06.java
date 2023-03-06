import java.util.Scanner;

public class Pets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double dogFood = Double.parseDouble(scanner.nextLine());
        double catFood = Double.parseDouble(scanner.nextLine());
        double turtleFood = Double.parseDouble(scanner.nextLine());

        double turtleFoodKilograms = turtleFood / 1000;
        double totalFood = (days * dogFood) + (days * catFood) + (days * turtleFoodKilograms);
        double diff = Math.abs(food - totalFood);

        if (food >= totalFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(diff));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(diff));
        }
    }
}