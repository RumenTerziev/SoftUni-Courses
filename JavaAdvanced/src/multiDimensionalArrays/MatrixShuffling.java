package multiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = inputData[0];
        int cols = inputData[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] commandInfo = input.split("\\s+");
            if (isCommandValid(commandInfo)) {

                try {
                    int firstRow = Integer.parseInt(commandInfo[1]);
                    int firstCol = Integer.parseInt(commandInfo[2]);

                    int secondRow = Integer.parseInt(commandInfo[3]);
                    int secondCol = Integer.parseInt(commandInfo[4]);


                    String elementOne = matrix[firstRow][firstCol];
                    String elementTwo = matrix[secondRow][secondCol];

                    matrix[firstRow][firstCol] = elementTwo;
                    matrix[secondRow][secondCol] = elementOne;

                    printTheMatrix(matrix, rows, cols);


                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    public static void printTheMatrix(String[][] matrix, int rows, int cows) {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cows; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isCommandValid(String[] commandInfo) {

        return commandInfo[0].equals("swap") && commandInfo.length == 5;
    }
}

