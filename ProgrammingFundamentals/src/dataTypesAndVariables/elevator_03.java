package dataTypesAndVariables;

import java.util.Scanner;

public class elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(peopleCount * 1.0 / elevatorCapacity);


        System.out.printf("%.0f", courses);
    }
}
