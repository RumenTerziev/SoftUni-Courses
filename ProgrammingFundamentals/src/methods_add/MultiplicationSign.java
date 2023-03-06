package methods_add;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        if (isZeroProduct(firstNumber, secondNumber, thirdNumber)) {
            System.out.println("zero");
        } else if (isPositiveProduct(firstNumber, secondNumber, thirdNumber)) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }


    }

    private static boolean isPositiveProduct(int firstNumber, int secondNumber, int thirdNumber) {


        boolean isPositive = false;
        int[] numbers = new int[]{firstNumber, secondNumber, thirdNumber};
        int counter = 0;
        int countZeros = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] < 0) {
                counter++;
            }
        }
        if (counter % 2 == 0) {
            isPositive = true;
        }

        return isPositive;
    }

    private static boolean isZeroProduct(int firstNumber, int secondNumber, int thirdNumber) {

        boolean isZero = false;
        int[] numbers = new int[]{firstNumber, secondNumber, thirdNumber};

        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                isZero = true;
                break;
            }
        }
        return isZero;
    }
}
