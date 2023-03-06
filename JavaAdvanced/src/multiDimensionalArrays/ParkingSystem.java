package multiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensionsInfo = scanner.nextLine();
        int[] dimensions = getIntegers(dimensionsInfo);
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = buildMatrix(rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("stop")) {

            int[] inputData = getIntegers(command);
            int enteredRow = inputData[0];
            int desiredRow = inputData[1];
            int desiredCol = inputData[2];

            int distance = Math.abs(desiredRow - enteredRow) + 1;
            boolean isFound = false;
            if (matrix[desiredRow][desiredCol] == 'F') {
                matrix[desiredRow][desiredCol] = 'B';
                distance = distance + desiredCol;
                isFound = true;
            } else {

                int thisCol = 0;

                for (int col = desiredCol; col >= 1; col--) {
                    if (matrix[desiredRow][col] == 'F') {
                        thisCol = col;
                        isFound = true;
                        break;
                    }
                }

                int thatCol = 0;
                for (int col = desiredCol; col < cols; col++) {

                    if (matrix[desiredRow][col] == 'F') {
                        thatCol = col;

                        isFound = true;
                        break;
                    }
                }

                if (Math.abs(desiredCol - thisCol) <= Math.abs(desiredCol - thatCol) && thisCol > 0) {
                    matrix[desiredRow][thisCol] = 'B';
                    distance += thisCol;
                } else if (thatCol > 0) {
                    matrix[desiredRow][thatCol] = 'B';
                    distance += thatCol;
                }

            }

            if (isFound) {
                System.out.printf("%d%n", distance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }
            command = scanner.nextLine();
        }
    }

    private static int[] getIntegers(String command) {
        return Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static char[][] buildMatrix(int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] = 'F';
            }
        }

        return matrix;
    }
}
