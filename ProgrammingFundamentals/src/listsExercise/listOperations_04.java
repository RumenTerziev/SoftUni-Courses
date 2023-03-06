package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];

            switch (commandType) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commandLine[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandLine[1]);
                    int insertIndex = Integer.parseInt(commandLine[2]);
                    if (isValidIndex(numbers, insertIndex)) {
                        numbers.add(insertIndex, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(commandLine[1]);
                    if (isValidIndex(numbers, removeIndex)) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commandLine[1];
                    int count = Integer.parseInt(commandLine[2]);
                    switch (direction) {
                        case "left":

                            for (int i = 1; i <= count; i++) {
                                int currentFirst = numbers.get(0);
                                numbers.add(currentFirst);
                                numbers.remove(numbers.get(0));
                            }
                            break;

                        case "right":

                            for (int i = 1; i <= count; i++) {
                                int currentLast = numbers.get(numbers.size() - 1);
                                numbers.add(0, currentLast);
                                numbers.remove(numbers.size() - 1);
                            }

                            break;
                    }
                    break;
            }

            command = scanner.nextLine();
        }


        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }

    public static boolean isValidIndex(List<Integer> numbersList, int index) {
        return index >= 0 && index <= numbersList.size() - 1;
    }
}
