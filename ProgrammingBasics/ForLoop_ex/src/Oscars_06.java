import java.util.Scanner;

public class Oscars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actor = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int evaluators = Integer.parseInt(scanner.nextLine());


        double totalPoints = academyPoints;
        for (int countEvaluators = 1; countEvaluators <= evaluators; countEvaluators++) {
            String nameEvaluator = scanner.nextLine();
            double pointsEvaluator = Double.parseDouble(scanner.nextLine());
            double currentPoints = (nameEvaluator.length() * pointsEvaluator) / 2;
            if (totalPoints < 1250.5) {
                totalPoints = totalPoints + currentPoints;
            }

        }
        if (totalPoints > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actor, totalPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actor, Math.abs(1250.5 - totalPoints));
        }

    }
}