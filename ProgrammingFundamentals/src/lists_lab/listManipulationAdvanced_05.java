package lists_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];
            switch (commandType) {
                case "Contains":
                    int numberToCheck = Integer.parseInt(commandLine[1]);
                    if (numbersList.contains(numberToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = commandLine[1];
                    if (evenOrOdd.equals("even")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) % 2 == 0) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    } else if (evenOrOdd.equals("odd")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) % 2 != 0) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i <= numbersList.size() - 1; i++) {
                        sum += numbersList.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = commandLine[1];
                    int number = Integer.parseInt(commandLine[2]);
                    if (condition.equals(">=")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) >= number) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    } else if (condition.equals("<")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) < number) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    } else if (condition.equals(">")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) > number) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    } else if (condition.equals("<=")) {
                        String result = "";
                        for (int i = 0; i <= numbersList.size() - 1; i++) {
                            if (numbersList.get(i) <= number) {
                                result = result + numbersList.get(i) + " ";
                            }
                        }
                        System.out.println(result.trim());
                    }
                    break;

            }

            command = scanner.nextLine();
        }

    }
}
