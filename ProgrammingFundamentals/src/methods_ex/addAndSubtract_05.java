package methods_ex;

import java.util.Scanner;

public class addAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = addNumbers(firstNum, secondNum);
        int result = subtractNumbers(sum, thirdNum);

        System.out.println(result);


    }

    private static int addNumbers(int numberOne, int numberTwo) {

        return numberOne + numberTwo;

    }

    private static int subtractNumbers(int sum, int number) {

        return sum - number;
    }

}
