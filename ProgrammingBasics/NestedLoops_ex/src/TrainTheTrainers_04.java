import java.util.Scanner;

public class TrainTheTrainers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evaluators = Integer.parseInt(scanner.nextLine());


        int presentationCount = 0;
        double totalAverageSum = 0;
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String presentationName = input;
            presentationCount++;

            double sumGrades = 0;
            double averageGrade = 0;
            for (int n = 1; n <= evaluators; n++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                sumGrades = sumGrades + currentGrade;
            }
            averageGrade = sumGrades / evaluators;


            System.out.printf("%s - %.2f.%n", presentationName, averageGrade);

            totalAverageSum = totalAverageSum + averageGrade;
            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalAverageSum / presentationCount);
    }
}
