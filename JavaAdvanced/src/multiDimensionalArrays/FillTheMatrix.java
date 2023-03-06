package multiDimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(",\\s+");
        int dimensions = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimensions][dimensions];


        if (pattern.equals("A")) {

            fillMatrix(matrix);

        } else if (pattern.equals("B")) {

            fillMatrixByPattern(matrix);

        }


        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix) {
        int counter = 1;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {
                matrix[row][column] = counter;
                counter++;
            }
        }
    }

    private static void fillMatrixByPattern(int[][] matrix) {

        int counter = 1;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {

                if (column % 2 == 0) {
                    matrix[row][column] = counter;
                }
                counter++;
            }
        }

        int secondCounter = 1;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = matrix[column].length - 1; row >= 0; row--) {

                if (column % 2 != 0) {
                    matrix[row][column] = secondCounter;
                }
                secondCounter++;
            }
        }

    }
}
