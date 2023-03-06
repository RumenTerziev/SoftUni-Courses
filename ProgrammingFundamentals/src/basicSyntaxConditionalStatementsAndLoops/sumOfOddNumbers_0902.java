package basicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class sumOfOddNumbers_0902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sumOddNumbers = 0;
        int currentNum = 0;
        int oddNumbersCount = 0;
        while (oddNumbersCount < number) {
            currentNum++;
            if (currentNum % 2 != 0) {
                sumOddNumbers = sumOddNumbers + currentNum;
                System.out.println(currentNum);
                oddNumbersCount++;
            }
        }
        System.out.printf("Sum: %d", sumOddNumbers);
    }
}
