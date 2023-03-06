package multiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Infa {
    public static void main(String[] args) {
        //MockUtil.mockIn("/tmp/in.txt");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] dimensions = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = buildMatrix(rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            matrix = executeCommand(matrix, command);
            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static int[][] executeCommand(int[][] matrix, String command) {
        int[] commandData = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowToBomb = commandData[0];
        int colToBomb = commandData[1];
        int radius = commandData[2];

        int emptyRows = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] oldAr = matrix[i];

            if (rowToBomb == i) {
                int startIndex = colToBomb - radius;
                int endIndex = colToBomb + radius;

                matrix[i] = remove(oldAr, startIndex, endIndex);
                if (matrix[i].length == 0) {
                    emptyRows++;
                }

            } else if (radius >= Math.abs(rowToBomb - i) && colToBomb >= 0 && colToBomb < oldAr.length) {
                matrix[i] = remove(oldAr, colToBomb, colToBomb);
                if (matrix[i].length == 0) {
                    emptyRows++;
                }
            }
        }

        if (emptyRows == 0) {
            return matrix;
        }

        int[][] newMatrix = new int[matrix.length - emptyRows][];

        int newArIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                newMatrix[newArIndex++] = matrix[i];
            }
        }

        return newMatrix;
    }

    private static int[] remove(int[] ar, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return ar;
        }

        if (startIndex > ar.length - 1) {
            return ar;
        }

        if (endIndex < 0) {
            return ar;
        }

        if (startIndex < 0) {
            startIndex = 0;
        }

        if (endIndex > ar.length - 1) {
            endIndex = ar.length - 1;
        }

        int removed = endIndex - startIndex + 1;


        int[] result = new int[ar.length - removed];


        int newArIndex = 0;

        for (int i = 0; i < ar.length; i++) {
            boolean isWithin = startIndex <= i && endIndex >= i;
            if (!isWithin) {
                result[newArIndex++] = ar[i];
            }
        }

        return result;
    }


    private static int[][] buildMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ++counter;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

