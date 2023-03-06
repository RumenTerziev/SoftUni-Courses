import java.util.Scanner;

public class FinalCompetition_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberDancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();


        double earnedSum = 0;

        if (season.equals("summer")) {
            switch (place) {
                case "Bulgaria":
                    earnedSum = points * numberDancers;
                    earnedSum = earnedSum - (earnedSum * 0.05);
                    break;
                case "Abroad":
                    earnedSum = numberDancers * points + ((numberDancers * points) * 0.5);
                    earnedSum = earnedSum - (earnedSum * 0.1);
                    break;
            }

        } else if (season.equals("winter")) {
            switch (place) {
                case "Bulgaria":
                    earnedSum = points * numberDancers;
                    earnedSum = earnedSum - (earnedSum * 0.08);
                    break;
                case "Abroad":
                    earnedSum = numberDancers * points + ((points * numberDancers) * 0.5);
                    earnedSum = earnedSum - (earnedSum * 0.15);
                    break;
            }
        }
        double charity = 0.75 * earnedSum;
        double finalMoney = earnedSum - charity;
        double moneyPerDancer = finalMoney / numberDancers;


        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f", moneyPerDancer);
    }
}
