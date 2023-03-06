package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class anonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] commandLine = command.split(" ");
            String commandType = commandLine[0];

            switch (commandType) {
                case "merge":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > stringList.size() - 1) {
                        endIndex = stringList.size() - 1;
                    }

                    boolean isValidIndex = startIndex <= stringList.size() - 1 && endIndex >= 0 && startIndex < endIndex;

                    if (isValidIndex) {
                        String result = "";
                        for (int i = startIndex; i <= endIndex; i++) {
                            result += stringList.get(i);
                        }

                        for (int j = startIndex; j <= endIndex; j++) {
                            stringList.remove(startIndex);
                        }
                        stringList.add(startIndex, result);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commandLine[1]);
                    int parts = Integer.parseInt(commandLine[2]);

                    String elementToDivide = stringList.get(index);
                    stringList.remove(index);

                    int partSize = elementToDivide.length() / parts;

                    int beginOfText = 0;
                    for (int part = 1; part < parts; part++) {
                        stringList.add(index, elementToDivide.substring(beginOfText, beginOfText + partSize));
                        index++;
                        beginOfText += partSize;
                    }
                    stringList.add(index, elementToDivide.substring(beginOfText));
                    break;
            }
            command = scanner.nextLine();
        }
        for (String element : stringList) {
            System.out.print(element + " ");
        }
    }
}
