import java.util.Scanner;

public class GameOfIntervals_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());

        double points = 0;
        int invalid = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;
        for (int i = 1; i <= moves; i++) {
            double currentNum = Double.parseDouble(scanner.nextLine());

            if (currentNum < 0 || currentNum > 50) {
                points = points / 2;
                invalid++;
            } else if (currentNum >= 0 && currentNum <= 9) {
                points = points + (currentNum * 0.2);
                first++;
            } else if (currentNum <= 19) {
                points = points + (currentNum * 0.3);
                second++;
            } else if (currentNum <= 29) {
                points = points + (currentNum * 0.4);
                third++;
            } else if (currentNum <= 39) {
                points = points + 50;
                fourth++;
            } else if (currentNum <= 50) {
                points = points + 100;
                fifth++;
            }
        }

        System.out.printf("%.2f%n", points);
        System.out.printf("From 0 to 9: %.2f%%%n", first * 1.0 / moves * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", second * 1.0 / moves * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", third * 1.0 / moves * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", fourth * 1.0 / moves * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", fifth * 1.0 / moves * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", invalid * 1.0 / moves * 100);
    }
}
