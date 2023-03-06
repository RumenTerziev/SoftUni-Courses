package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class softUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> softUniSchedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            String[] commandLine = command.split(":");
            String commandType = commandLine[0];
            switch (commandType) {
                case "Add":
                    String lessonToAdd = commandLine[1];
                    if (!softUniSchedule.contains(lessonToAdd)) {
                        softUniSchedule.add(lessonToAdd);
                    }
                    break;
                case "Insert":
                    String lessonToInsert = commandLine[1];
                    int indexToInsert = Integer.parseInt(commandLine[2]);
                    if (!softUniSchedule.contains(lessonToInsert)) {
                        softUniSchedule.add(indexToInsert, lessonToInsert);
                    }
                    break;
                case "Remove":
                    String lessonToRemove = commandLine[1];
                    softUniSchedule.remove(lessonToRemove);

                    break;
                case "Swap":
                    String firstElement = commandLine[1];
                    int indexOfFirstElement = softUniSchedule.indexOf(firstElement);
                    String secondElement = commandLine[2];
                    int indexOfSecondElement = softUniSchedule.indexOf(secondElement);
                    String firstElementExercise = firstElement + "-Exercise";
                    String secondElementExercise = secondElement + "-Exercise";

                    if (softUniSchedule.contains(firstElement) && softUniSchedule.contains(secondElement)
                            && softUniSchedule.contains(firstElementExercise)
                            && softUniSchedule.contains(secondElementExercise)) {

                        int indexOfFirstElementEx = softUniSchedule.indexOf(firstElementExercise);
                        int secondElementEx = softUniSchedule.indexOf(secondElementExercise);
                        softUniSchedule.set(indexOfFirstElement, secondElement);
                        softUniSchedule.set(indexOfSecondElement, firstElement);
                        softUniSchedule.set(indexOfFirstElementEx, secondElementExercise);
                        softUniSchedule.set(secondElementEx, firstElementExercise);
                    } else if (softUniSchedule.contains(firstElement) && softUniSchedule.contains(secondElement)
                            && softUniSchedule.contains(firstElementExercise)) {
                        int indexOfFirstElementEx = softUniSchedule.indexOf(firstElementExercise);
                        softUniSchedule.set(indexOfFirstElement, secondElement);
                        softUniSchedule.set(indexOfSecondElement, firstElement);
                        softUniSchedule.add(indexOfSecondElement + 1, firstElementExercise);
                        softUniSchedule.remove(indexOfFirstElementEx + 1);


                    } else if (softUniSchedule.contains(firstElement) && softUniSchedule.contains(secondElement)
                            && softUniSchedule.contains(secondElementExercise)) {
                        int indexOfSecondElementEx = softUniSchedule.indexOf(secondElementExercise);

                        softUniSchedule.set(indexOfFirstElement, secondElement);
                        softUniSchedule.set(indexOfSecondElement, firstElement);
                        softUniSchedule.add(indexOfFirstElement + 1, secondElementExercise);
                        softUniSchedule.remove(indexOfSecondElementEx + 1);


                    } else if (softUniSchedule.contains(firstElement) && softUniSchedule.contains(secondElement)) {
                        softUniSchedule.set(indexOfFirstElement, secondElement);
                        softUniSchedule.set(indexOfSecondElement, firstElement);
                    }

                    break;
                case "Exercise":
                    String lesson = commandLine[1];
                    String exercise = lesson + "-Exercise";


                    if (softUniSchedule.contains(lesson)) {
                        int indexOfLesson = softUniSchedule.indexOf(lesson);
                        if (!softUniSchedule.contains(exercise)) {
                            softUniSchedule.add(indexOfLesson + 1, exercise);
                        }
                    } else {
                        softUniSchedule.add(lesson);
                        softUniSchedule.add(exercise);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i <= softUniSchedule.size() - 1; i++) {
            System.out.printf("%d.%s%n", i + 1, softUniSchedule.get(i));
        }
    }
}
