package multiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getIntegers(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char newColor = scanner.nextLine().charAt(0);

        int[] startingPosition = getIntegers(scanner);
        int startRow = startingPosition[0];
        int startCol = startingPosition[1];

        char colorToReplace = matrix[startRow][startCol];

        paintMatrix(matrix, newColor, colorToReplace, startRow, startCol);

        Arrays.stream(matrix).iterator().forEachRemaining(System.out::println);
    }

    private static void paintMatrix(char[][] matrix, char newColor, char colorToReplace, int startRow, int startCol) {

        if (isOutOfBounds(matrix, startRow, startCol) || matrix[startRow][startCol] != colorToReplace) {
            return;
        }

        matrix[startRow][startCol] = newColor;



        Arrays.stream(matrix).iterator().forEachRemaining(System.out::println);

        System.out.println("<=======================================>");

        paintMatrix(matrix, newColor, colorToReplace, startRow + 1, startCol);
        paintMatrix(matrix, newColor, colorToReplace, startRow - 1, startCol);
        paintMatrix(matrix, newColor, colorToReplace, startRow, startCol + 1);
        paintMatrix(matrix, newColor, colorToReplace, startRow, startCol - 1);
    }

    private static boolean isOutOfBounds(char[][] matrix, int startRow, int startCol) {
        return startRow < 0 || startRow >= matrix.length || startCol < 0 || startCol >= matrix[startRow].length;
    }


    private static int[] getIntegers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
