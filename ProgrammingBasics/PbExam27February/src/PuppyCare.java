import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodKilograms = Integer.parseInt(scanner.nextLine());


        int totalFood = 0;
        String input = scanner.nextLine();
        while (!input.equals("Adopted")) {
            int foodGramsPerFeed = Integer.parseInt(input);
            totalFood = totalFood + foodGramsPerFeed;



            input = scanner.nextLine();
        }
        int foodGrams = foodKilograms * 1000;
        int diff = Math.abs(foodGrams - totalFood);
        if (totalFood <= foodGrams) {
            System.out.printf("Food is enough! Leftovers: %d grams.",diff);
        } else {
            System.out.printf("Food is not enough. You need %d grams more",diff);
        }
    }
}