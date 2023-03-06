package multiDimensionalArrays;

import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] singleRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = singleRow;

        }

        List<int[]> matrixRows = new ArrayList<>();

        List<List<Integer>> listMatrixRows = new ArrayList<>();

        int newMatrixRowCounter = 0;
        int[][] newMatrix = new int[rows + cols - 1][];

        int thisRow = rows - 1;
        while (thisRow == rows - 1) {

            int arrayRowsCounter = 0;

            for (int thisCol = cols - 1; thisCol >= 0; thisCol--) {

                List<Integer> singleMatrixRow = new ArrayList<>();

                int counter = 0;
                int[] singleArrayRow = new int[cols];
                for (int row = rows - 1, col = thisCol; row >= 0 && col < cols; row--, col++) {
                    singleMatrixRow.add(matrix[row][col]);
                    singleArrayRow[counter] = matrix[row][col];
                    counter++;
                }


                listMatrixRows.add(singleMatrixRow);
                newMatrix[arrayRowsCounter] = singleArrayRow;
                newMatrixRowCounter++;
                arrayRowsCounter++;
            }

            thisRow--;
        }

        int newCol = 0;

        while (newCol == 0) {

            for (int newRow = thisRow; newRow >= 0; newRow--) {

                List<Integer> newMatrixRows = new ArrayList<>();

                int[] nextNewMatrixRows = new int[cols];


                int newCounter = 0;
                for (int row = newRow, col = 0; row >= 0 && col < cols; row--, col++) {
                  newMatrixRows.add(matrix[row][col]);
                  nextNewMatrixRows[newCounter] = matrix[row][col];

                }

                listMatrixRows.add(newMatrixRows);

                newMatrix[newMatrixRowCounter] = nextNewMatrixRows;
            }

            newCol++;
        }

        for (var row : listMatrixRows) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }


        System.out.println("<================================================================>");


        for (int[] singleRow : newMatrix) {
            for (int element : singleRow) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
