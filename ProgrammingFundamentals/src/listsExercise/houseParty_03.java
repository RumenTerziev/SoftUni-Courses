package listsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class houseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> guestsList = new ArrayList<>();


        int index = 0;
        while (index < commandsCount) {

            String[] commandLine = scanner.nextLine().split(" ");
            String currentGuest = commandLine[0];
            String goingOrNot = commandLine[2];

            if (index == 0) {
                if (goingOrNot.equals("going!")) {
                    guestsList.add(currentGuest);
                } else if (goingOrNot.equals("not")) {
                    System.out.printf("%s is not in the list!%n", currentGuest);
                }
            } else {
                switch (goingOrNot) {
                    case "going!":
                        boolean isAlreadyInTheList = false;
                        for (int i = 0; i <= guestsList.size() - 1; i++) {
                            if (guestsList.get(i).equals(currentGuest)) {
                                System.out.printf("%s is already in the list!%n", currentGuest);
                                isAlreadyInTheList = true;
                                break;
                            }

                        }
                        if (!isAlreadyInTheList) {
                            guestsList.add(currentGuest);
                        }

                        break;

                    case "not":

                        boolean isRemoved = false;
                        for (int i = 0; i <= guestsList.size() - 1; i++) {
                            if (guestsList.get(i).equals(currentGuest)) {
                                guestsList.remove(guestsList.get(i));
                                isRemoved = true;
                                i -= 1;

                            }
                        }
                        if (!isRemoved) {
                            System.out.printf("%s is not in the list!%n", currentGuest);
                        }
                        break;
                }
            }

            index++;
        }
        for (String name : guestsList) {
            System.out.println(name);
        }
    }
}

