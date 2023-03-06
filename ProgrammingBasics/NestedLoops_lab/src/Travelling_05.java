import java.util.Scanner;

public class Travelling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();


        while (!command.equals("End")) {
            String destination = command;
            double neededMoney = Double.parseDouble(scanner.nextLine());

            double savedMoney = 0;
            while (savedMoney < neededMoney) {
                double currentMoney = Double.parseDouble(scanner.nextLine());
                savedMoney = savedMoney + currentMoney;


            }
            System.out.printf("Going to %s!%n", destination);
            command = scanner.nextLine();


        }
    }
}
