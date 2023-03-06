import java.util.Scanner;

public class Walking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int sumSteps = 0;
        while (!command.equals("Going home")) {
            int steps = Integer.parseInt(command);
            sumSteps = sumSteps + steps;
            if (sumSteps >= 10000) {
                break;
            }
            command = scanner.nextLine();
            }

        if (command.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            sumSteps = sumSteps + stepsToHome;
        }

        if (sumSteps >= 10000) {
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", Math.abs(sumSteps - 10000));
        } else {
            System.out.printf("%d more steps to reach goal.", Math.abs(sumSteps - 10000));
        }
    }
}
