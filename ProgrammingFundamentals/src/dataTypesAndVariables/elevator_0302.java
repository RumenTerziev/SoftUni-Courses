package dataTypesAndVariables;

import java.util.Scanner;

public class elevator_0302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int courses = peopleCount / elevatorCapacity;

        if (peopleCount % elevatorCapacity != 0) {
            courses += 1;
        }


        System.out.println(courses);
    }
}
