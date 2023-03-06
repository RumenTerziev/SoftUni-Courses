package methods_ex;

import java.util.Scanner;

public class factorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        long firstFact = findFactorial(firstNumber);
        long secondFact = findFactorial(secondNumber);

        System.out.printf("%.2f", findDivision(firstFact, secondFact));
    }

    private static long findFactorial(int number) {

        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static double findDivision(long firstFact, long secondFact) {
        return 1.0 * firstFact / secondFact;
    }
}
