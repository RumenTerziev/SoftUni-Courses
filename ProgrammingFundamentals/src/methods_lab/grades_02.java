package methods_lab;

import java.util.Scanner;

public class grades_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        findGrade(grade);


    }

    public static void findGrade(double mark) {

        if (mark >= 2 && mark < 3) {
            System.out.println("Fail");
        } else if (mark >= 3 && mark < 3.5) {
            System.out.println("Poor");
        } else if (mark >= 3.5 && mark < 4.5) {
            System.out.println("Good");
        } else if (mark >= 4.5 && mark < 5.5) {
            System.out.println("Very good");
        } else if (mark >= 5.5 && mark <= 6) {
            System.out.println("Excellent");
        }
    }
}