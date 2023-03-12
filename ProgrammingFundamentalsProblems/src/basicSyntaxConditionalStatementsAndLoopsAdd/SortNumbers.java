package basicSyntaxConditionalStatementsAndLoopsAdd;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        int [] numbers = {firstNum, secondNum, thirdNum};

        Arrays.sort(numbers);

        System.out.printf("%d%n%d%n%d", numbers[2], numbers[1], numbers[0]);

    }
}
