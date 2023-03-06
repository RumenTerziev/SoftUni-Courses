package multiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixDimensions = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[matrixDimensions][matrixDimensions];


        for (int row = 0; row < matrixDimensions; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int firstDiagonalSum = 0;
        for (int row = 0, col = 0; row < matrixDimensions && col < matrixDimensions; row++, col++) {
            firstDiagonalSum += matrix[row][col];
        }

        int secondDiagonalSum = 0;
        for (int row = matrixDimensions - 1, col = 0; row >= 0 && col < matrixDimensions; row--, col++) {
            secondDiagonalSum += matrix[row][col];
        }

        int difference = Math.abs(firstDiagonalSum - secondDiagonalSum);

        System.out.println(difference);
    }

}
