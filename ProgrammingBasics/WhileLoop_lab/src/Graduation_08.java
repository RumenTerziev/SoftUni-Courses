import java.util.Scanner;

public class Graduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int grade = 0;
        double sumGrade = 0;
        double averageGrade = 0;
        int countFailedGrades = 0;
        while (grade < 12) {
            double currentMark = Double.parseDouble(scanner.nextLine());
            sumGrade = sumGrade + currentMark;
            averageGrade = sumGrade / 12;
            if (currentMark < 4) {
                countFailedGrades++;
            }
            if (countFailedGrades > 1) {
                break;
            }
            grade++;
        }
        if (countFailedGrades > 1) {
            System.out.printf("%s has been excluded at %d grade", name, grade);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }
    }
}
