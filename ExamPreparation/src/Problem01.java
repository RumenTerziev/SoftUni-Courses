import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {

            List<String> commandLine = Arrays.stream(command.split(":")).collect(Collectors.toList());

            String typeOfCommand = commandLine.get(0);


            if (typeOfCommand.equals("Add Stop")) {
                int insertIndex = Integer.parseInt(commandLine.get(1));
                String insertString = commandLine.get(2);

                if (insertIndex >= 0 && insertIndex <= input.length() - 1) {
                    for (int i = 0; i < insertIndex; i++) {
                        char currentSymbol = input.charAt(i);
                        result.append(currentSymbol);
                    }
                    result.append(insertString);
                    for (int i = insertIndex; i <= input.length() - 1; i++) {
                        char currentSymbol = input.charAt(i);
                        result.append(currentSymbol);
                    }

                    input = result.toString();
                }

            } else if (typeOfCommand.equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commandLine.get(1));
                int endIndex = Integer.parseInt(commandLine.get(2));
                if (startIndex >= 0 && endIndex <= input.length() - 1 && startIndex <= endIndex) {
                    input = input.replace(input.substring(startIndex, endIndex + 1), "");
                }


            } else if (typeOfCommand.equals("Switch")) {
                String oldString = commandLine.get(1);
                String newString = commandLine.get(2);

                input = input.replace(oldString, newString);

            }

            System.out.println(input);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", input);
    }
}
