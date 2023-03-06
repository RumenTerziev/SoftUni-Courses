package multiDimensionalArrays;

import java.util.Scanner;


public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");


        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[rows][columns];


        fillTheMatrixWithPalindrome(rows, columns, matrix);

        printTheMatrix(matrix, rows, columns);
    }

    private static void printTheMatrix(String[][] matrix, int rows, int columns) {


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static void fillTheMatrixWithPalindrome(int rows, int columns, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                char outsideChar = (char) ('a' + row);
                char middleChar = (char) ('a' + row + col);
                String palindrome = String.valueOf(outsideChar)
                        .concat(String.valueOf(middleChar)).concat(String.valueOf(outsideChar));

                matrix[row][col] = palindrome;
            }
        }
    }
}
