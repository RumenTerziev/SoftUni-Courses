package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());


        int wagonCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];

            if (commandType.equals("Add")) {
                int passengersToAdd = Integer.parseInt(commandLine[1]);
                train.add(passengersToAdd);
            } else {
                int passengers = Integer.parseInt(commandLine[0]);

                for (int i = 0; i <= train.size() - 1; i++) {
                    int currentWagonPassengers = train.get(i);
                    if (currentWagonPassengers + passengers <= wagonCapacity) {
                        train.set(i, currentWagonPassengers + passengers);
                        break;
                    }
                }

            }

            command = scanner.nextLine();
        }
        for (int trainPassengers : train) {
            System.out.print(trainPassengers + " ");
        }
    }
}
