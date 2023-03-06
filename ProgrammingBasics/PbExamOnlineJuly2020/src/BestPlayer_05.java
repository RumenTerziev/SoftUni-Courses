import java.util.Scanner;

public class BestPlayer_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasScored = false;
        boolean isBest = false;
        String bestPlayer = "";
        int max = Integer.MIN_VALUE;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String playerName = command;
            int currentPlayerGoals = Integer.parseInt(scanner.nextLine());
            if (currentPlayerGoals > max) {
                max = currentPlayerGoals;
                isBest = true;
                bestPlayer = playerName;
            } else if (currentPlayerGoals >= 3 && currentPlayerGoals < 10) {
                    hasScored = true;
            }

            command = scanner.nextLine();
        }



        System.out.printf("%s is the best player!%n",bestPlayer);

        if (hasScored) {

        }
    }
}
