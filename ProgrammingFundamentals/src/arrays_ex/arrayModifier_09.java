package arrays_ex;

import java.util.Arrays;
import java.util.Scanner;

public class arrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandArray = command.split(" ");
            String action = commandArray[0];

            switch (action) {

                case "swap":
                    int firstIndex = Integer.parseInt(commandArray[1]);
                    int elementOne = numArr[firstIndex];
                    int secondIndex = Integer.parseInt(commandArray[2]);
                    int elementTwo = numArr[secondIndex];

                    numArr[firstIndex] = elementTwo;
                    numArr[secondIndex] = elementOne;
                    break;

                case "multiply":
                    int multiplyIndexOne = Integer.parseInt(commandArray[1]);
                    int multiplyElementOne = numArr[multiplyIndexOne];
                    int multiplyIndexTwo = Integer.parseInt(commandArray[2]);
                    int multiplyElementTwo = numArr[multiplyIndexTwo];
                    int product = multiplyElementOne * multiplyElementTwo;

                    numArr[multiplyIndexOne] = product;
                    break;

                case "decrease":
                    for (int i = 0; i <= numArr.length - 1; i++) {
                        numArr[i] = numArr[i] - 1;
                    }
                    break;

            }

            command = scanner.nextLine();
        }
        for (int index = 0; index <= numArr.length - 1; index++) {
            if (index != numArr.length - 1) {
                System.out.print(numArr[index] + ", ");
            } else {
                System.out.print(numArr[numArr.length - 1]);
            }
        }
    }
}
