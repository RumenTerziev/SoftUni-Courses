package arrays_add;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldLength = Integer.parseInt(scanner.nextLine());
        int[] ladyBugsIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        if (fieldLength > 0) {
            int[] initialField = new int[fieldLength];

            for (int j = 0; j <= ladyBugsIndexes.length - 1; j++) {
                int currentLadyBugIndex = ladyBugsIndexes[j];
                if (isIndexValid(initialField, currentLadyBugIndex)) {
                    initialField[currentLadyBugIndex] = 1;
                }
            }


            String command = scanner.nextLine();
            while (!command.equals("end")) {
                String[] commandLine = command.split(" ");
                int ladyBugIndex = Integer.parseInt(commandLine[0]);
                String direction = commandLine[1];
                int flyLength = Integer.parseInt(commandLine[2]);

                switch (direction) {
                    case "left":
                        if (isIndexValid(initialField, ladyBugIndex) && initialField[ladyBugIndex] == 1) {
                            initialField[ladyBugIndex] = 0;
                            if (ladyBugIndex - flyLength >= 0 && ladyBugIndex - flyLength <= initialField.length - 1) {
                                for (int i = ladyBugIndex - flyLength; i >= 0; i -= flyLength) {
                                    if (initialField[i] != 1) {
                                        initialField[i] = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "right":
                        if (isIndexValid(initialField, ladyBugIndex) && initialField[ladyBugIndex] == 1) {
                            initialField[ladyBugIndex] = 0;
                            if (ladyBugIndex + flyLength >= 0 && ladyBugIndex + flyLength <= initialField.length - 1) {
                                for (int i = ladyBugIndex + flyLength; i <= initialField.length - 1; i += flyLength) {
                                    if (initialField[i] != 1) {
                                        initialField[i] = 1;
                                        break;
                                    }
                                }
                            }
                        }

                        break;
                }
                command = scanner.nextLine();
            }
            for (int element : initialField) {
                System.out.print(element + " ");
            }
        }
    }

    private static boolean isIndexValid(int[] array, int index) {
        return index >= 0 && index <= array.length - 1;
    }
}
