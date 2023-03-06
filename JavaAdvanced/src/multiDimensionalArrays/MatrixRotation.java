package multiDimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(input);
        int degrees = 0;
        while (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }


        List<String> matrixWords = new ArrayList<>();

        String currentRow = scanner.nextLine();
        while (!currentRow.equals("END")) {

            matrixWords.add(currentRow);

            currentRow = scanner.nextLine();
        }

        int maxLength = Integer.MIN_VALUE;

        for (String element : matrixWords) {

            if (element.length() > maxLength) {
                maxLength = element.length();
            }
        }


        int rows = matrixWords.size();
        int cols = maxLength;


        Character[][] matrix = new Character[rows][cols];


        for (int row = 0; row < rows; row++) {
            String currentWord = matrixWords.get(row);
            for (int col = 0; col < cols; col++) {

                if (col < currentWord.length()) {
                    matrix[row][col] = currentWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        Character[][] newMatrix = new Character[cols][rows];

        if (degrees > 360) {
            degrees = degrees % 360;
        }

        if (degrees == 0 || degrees == 360) {

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (degrees == 90) {


            for (int row = 0; row < cols; row++) {
                for (int col = 0; col < rows; col++) {
                    newMatrix[row][col] = matrix[col][row];
                }
            }

            for (int row = 0; row < cols; row++) {
                for (int col = rows - 1; col >= 0; col--) {
                    System.out.print(newMatrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {

            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }


        } else if (degrees == 270) {


            for (int row = 0; row < cols; row++) {
                for (int col = rows - 1; col >= 0; col--) {
                    newMatrix[row][col] = matrix[col][row];
                }
            }

            for (int row = cols - 1; row >= 0; row--) {
                for (int col = 0; col < rows; col++) {
                    System.out.print(newMatrix[row][col]);
                }
                System.out.println();
            }

        }


    }
}
