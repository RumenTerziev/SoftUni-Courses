package multiDimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] dimensions = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                matrix[row][col] = counter;
                counter++;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {

            int[] commandData = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rowToBomb = commandData[0];
            int colToBomb = commandData[1];
            int radius = commandData[2];

            int startingElementForRow;
            if (rowToBomb - radius >= 0) {
                startingElementForRow = rowToBomb - radius;
            } else {
                startingElementForRow = 0;
            }

            int startingElementForCol;
            if (colToBomb - radius >= 0) {
                startingElementForCol = colToBomb - radius;
            } else {
                startingElementForCol = 0;
            }

            for (int row = startingElementForRow; row <= rowToBomb + radius; row++) {
                if (isRowValid(matrix, row) && isColValid(matrix[row], colToBomb)) {
                    matrix[row][colToBomb] = 0;
                }
            }

            for (int col = startingElementForCol; col <= colToBomb + radius; col++) {
                if (isRowValid(matrix, rowToBomb) && isColValid(matrix[rowToBomb], col)) {
                    matrix[rowToBomb][col] = 0;
                }
            }

            List<int[]> newMatrixRows = new ArrayList<>();

            for (int[] row : matrix) {
                List<Integer> currentRow = new ArrayList<>();

                for (int element : row) {
                    if (element != 0) {
                        currentRow.add(element);
                    }
                }

                int[] newRow = new int[currentRow.size()];

                for (int index = 0; index < currentRow.size(); index++) {
                    newRow[index] = currentRow.get(index);
                }

                if (!currentRow.isEmpty()) {
                    newMatrixRows.add(newRow);
                }
            }

            int[][] newMatrix = new int[newMatrixRows.size()][];

            for (int row = 0; row < newMatrix.length; row++) {

                newMatrix[row] = newMatrixRows.get(row);
            }

            matrix = newMatrix;
            command = scanner.nextLine();
        }

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isColValid(int[] thisRow, int index) {
        return index >= 0 && index < thisRow.length;
    }

    private static boolean isRowValid(int[][] matrix, int row) {
        return row >= 0 && row < matrix.length;
    }
}
