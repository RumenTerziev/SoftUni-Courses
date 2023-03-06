import java.util.Scanner;

public class Grades_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        double sumGrade = 0;
        double average = 0;
        double topStudents = 0;
        double betweenFiveAndFour = 0;
        double betweenFourAndThree = 0;
        double failed = 0;
        double topPercent = 0;
        double betweenFiveAndFourPercent = 0;
        double betweenFourAndThreePercent = 0;
        double failedPercent = 0;
        for (int i = 1; i <= countStudents; i++) {
            double currentStudentGrade = Double.parseDouble(scanner.nextLine());


            if (currentStudentGrade >= 2.00 && currentStudentGrade <= 2.99) {
                failed++;
            } else if (currentStudentGrade >= 3.00 && currentStudentGrade <= 3.99) {
                betweenFourAndThree++;
            } else if (currentStudentGrade >= 4.00 && currentStudentGrade <= 4.99) {
                betweenFiveAndFour++;
            } else if (currentStudentGrade >= 5.00) {
                topStudents++;
            }
            sumGrade = sumGrade + currentStudentGrade;

        }
        average = sumGrade / countStudents;
        topPercent = topStudents / countStudents * 100;
        betweenFiveAndFourPercent = betweenFiveAndFour / countStudents * 100;
        betweenFourAndThreePercent = betweenFourAndThree / countStudents * 100;
        failedPercent = failed / countStudents * 100;

        System.out.printf("Top students: %.2f%%%n", topPercent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", betweenFiveAndFourPercent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", betweenFourAndThreePercent);
        System.out.printf("Fail: %.2f%%%n", failedPercent);
        System.out.printf("Average: %.2f", average);

    }
}
