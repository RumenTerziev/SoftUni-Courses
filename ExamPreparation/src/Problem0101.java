import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Problem0101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder(input);

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {

            String[] commandLine = command.split(":");
            String typeOfCommand = commandLine[0];


            if (typeOfCommand.equals("Add Stop")) {
                int insertIndex = Integer.parseInt(commandLine[1]);
                String insertString = commandLine[2];

                if (insertIndex >= 0 && insertIndex <= input.length() - 1) {
                    result.insert(insertIndex, insertString);
                }

            } else if (typeOfCommand.equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commandLine[1]);
                int endIndex = Integer.parseInt(commandLine[2]);
                if (startIndex >= 0 && endIndex <= input.length() - 1 && startIndex <= endIndex) {
                    result.delete(startIndex, endIndex + 1);
                }


            } else if (typeOfCommand.equals("Switch")) {
                String oldString = commandLine[1];
                String newString = commandLine[2];

                if (input.contains(oldString)) {
                    String updatedText = result.toString().replace(oldString, newString);
                    result = new StringBuilder(updatedText);
                }
            }

            input = result.toString();
            System.out.println(result);
            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + result);
    }
}


