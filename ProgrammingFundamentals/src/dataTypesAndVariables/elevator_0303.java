package dataTypesAndVariables;

import java.util.Scanner;

public class elevator_0303 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        short courses = 0;
        while (countPeople > 0) {
            countPeople = countPeople - elevatorCapacity;
            courses++;
        }
        System.out.println(courses);
    }
}
