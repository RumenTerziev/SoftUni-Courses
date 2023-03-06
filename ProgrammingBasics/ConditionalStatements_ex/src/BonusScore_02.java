import java.util.Scanner;

public class BonusScore_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numScore = Integer.parseInt(scanner.nextLine());

        double bonus = 0;

        if (numScore <= 100) {
            bonus = 5;
        } else if (numScore < 1000) {
            bonus = numScore * 0.20;
        } else {
            bonus = numScore * 0.10;
        }
        if (numScore % 2 == 0) {
            bonus = bonus + 1;
        }
        if (numScore % 10 == 5) {
            bonus = bonus + 2;
        }
        double result = numScore + bonus;
        System.out.printf("%.1f%n", bonus);
        System.out.printf("%.1f", result);
    }
}
