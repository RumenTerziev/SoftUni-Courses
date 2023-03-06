import java.util.Scanner;

public class TennisRanklist_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTournaments = Integer.parseInt(scanner.nextLine());
        int initialPoints = Integer.parseInt(scanner.nextLine());

        int sumPoints = initialPoints;
        int wonTournaments = 0;
        for (int n = 1; n <= countTournaments; n++) {
            String stage = scanner.nextLine();

            switch (stage) {
                case "W":
                    sumPoints = sumPoints + 2000;
                    wonTournaments++;
                    break;
                case "F":
                    sumPoints = sumPoints + 1200;
                    break;
                case "SF":
                    sumPoints = sumPoints + 720;
                    break;

            }
        }
        double averagePoints = Math.floor((sumPoints - initialPoints) / (countTournaments * 1.0));
        double percent = (wonTournaments / (countTournaments * 1.0)) * 100;
        System.out.printf("Final points: %d%n", sumPoints);
        System.out.printf("Average points: %.0f%n", averagePoints);
        System.out.printf("%.2f%%%n", percent);
    }
}
