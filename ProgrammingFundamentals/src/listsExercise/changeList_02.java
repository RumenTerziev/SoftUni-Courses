package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class changeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];

            switch (commandType) {

                case "Delete":

                    int elementToDelete = Integer.parseInt(commandLine[1]);


                    for (int i = 0; i <= numbersList.size() - 1; i++) {

                        if (numbersList.get(i) == elementToDelete) {
                            numbersList.remove(numbersList.get(i));
                            i -= 1;
                        }
                    }

                    break;

                case "Insert":

                    int elementToInsert = Integer.parseInt(commandLine[1]);
                    int positionToInsert = Integer.parseInt(commandLine[2]);

                    numbersList.add(positionToInsert, elementToInsert);
                    break;

            }


            command = scanner.nextLine();
        }

        for (int number : numbersList) {
            System.out.print(number + " ");
        }

    }
}