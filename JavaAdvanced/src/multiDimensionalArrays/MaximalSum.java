package multiDimensionalArrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getIntegers(scanner);

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] initialMatrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            initialMatrix[row] = getIntegers(scanner);
        }


        List<Integer> maxMatrixStartingElementCoordinates = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < columns - 2; col++) {

                int matrixSum = initialMatrix[row][col] + initialMatrix[row][col + 1] + initialMatrix[row][col + 2]
                        + initialMatrix[row + 1][col] + initialMatrix[row + 1][col + 1] + initialMatrix[row + 1][col + 2]
                        + initialMatrix[row + 2][col] + initialMatrix[row + 2][col + 1] + initialMatrix[row + 2][col + 2];


                if (matrixSum > maxSum) {
                    maxSum = matrixSum;
                    maxMatrixStartingElementCoordinates = Arrays.asList(row, col);

                }

//                for (int thisRow = row; thisRow < row + 3; thisRow++) {
//                    for (int thisCol = col; thisCol < col + 3; thisCol++) {
//
//                        matrixSum += initialMatrix[thisRow][thisCol];
//
//                        if (matrixSum > maxSum) {
//                            maxSum = matrixSum;
//                            maxMatrixStartingElementCoordinates = Arrays.asList(row, col);
//
//                        }
//                    }
//                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        for (int printRow = maxMatrixStartingElementCoordinates.get(0); printRow < maxMatrixStartingElementCoordinates.get(0) + 3; printRow++) {
            for (int printCol = maxMatrixStartingElementCoordinates.get(1); printCol < maxMatrixStartingElementCoordinates.get(1) + 3; printCol++) {

                System.out.print(initialMatrix[printRow][printCol] + " ");
            }
            System.out.println();
        }

    }


    private static int[] getIntegers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

}
