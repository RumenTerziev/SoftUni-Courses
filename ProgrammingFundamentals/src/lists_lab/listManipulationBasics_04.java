package lists_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];
            switch (commandType) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commandLine[1]);
                    numbersList.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(commandLine[1]);
                    if (numbersList.contains(numberToRemove)) {
                        numbersList.remove(Integer.valueOf(numberToRemove));
                    }
                    break;
                case "RemoveAt":
                    int removeIndex = Integer.parseInt(commandLine[1]);
                    numbersList.remove(removeIndex);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandLine[1]);
                    int insertIndex = Integer.parseInt(commandLine[2]);
                    numbersList.add(insertIndex, numberToInsert);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
    }
}
