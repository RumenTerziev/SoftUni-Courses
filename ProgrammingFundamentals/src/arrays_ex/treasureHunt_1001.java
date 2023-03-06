package arrays_ex;

import java.util.Scanner;

public class treasureHunt_1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] initialChest = scanner.nextLine().split("\\|");

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String [] commandType = command.split(" ");

            switch (commandType[0]) {

                case "Loot":

                    break;

                case "Drop":

                    break;

                case "Steal":

                    break;







            }





            command = scanner.nextLine();
        }
    }
}