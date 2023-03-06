package multiDimensionalArrays;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputLine = input.split("[()]");
        int degrees = Integer.parseInt(inputLine[1]);


        List<String> wordsForMatrix = new ArrayList<>();

        String nextRow = scanner.nextLine();
        while (!nextRow.equals("END")) {
            wordsForMatrix.add(nextRow);
            nextRow = scanner.nextLine();
        }

        int wordsMaxLength = Integer.MIN_VALUE;

        for (String element : wordsForMatrix) {

            if (element.length() > wordsMaxLength) {
                wordsMaxLength = element.length();
            }
        }


        int rows = wordsForMatrix.size();
        int cols = wordsMaxLength;


        Character[][] matrix = new Character[rows][cols];


        for (int row = 0; row < rows; row++) {
            String currentWord = wordsForMatrix.get(row);
            for (int col = 0; col < cols; col++) {

                if (col < currentWord.length()) {
                    matrix[row][col] = currentWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }


        int angle = degrees % 360;

        switch (angle) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:

                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
            case 180:

                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
            case 270:

                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }

    }
}
