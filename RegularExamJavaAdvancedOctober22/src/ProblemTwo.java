import java.util.Arrays;
import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }


        int carRow = 0;
        int carCol = 0;

        matrix[carRow][carCol] = 'C';

        String command = scanner.nextLine();


        int kilometersPassed = 0;
        boolean hasFinished = false;
        while (!command.equals("End")) {


            matrix[carRow][carCol] = '.';
            switch (command) {
                case "up":

                    if (isValidRow(matrix, carRow - 1)) {
                        carRow--;
                    }

                    break;
                case "down":

                    if (isValidRow(matrix, carRow + 1)) {
                        carRow++;
                    }

                    break;
                case "left":

                    if (isValidCol(matrix, carRow, carCol - 1)) {
                        carCol--;
                    }

                    break;
                case "right":

                    if (isValidCol(matrix, carRow, carCol + 1)) {
                        carCol++;
                    }

                    break;

            }

            kilometersPassed += 10;

            if (matrix[carRow][carCol] == '.') {
                matrix[carRow][carCol] = 'C';
            }

            if (matrix[carRow][carCol] == 'T') {
                matrix[carRow][carCol] = '.';


                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col] == 'T') {
                            carRow = row;
                            carCol = col;
                            break;
                        }
                    }

                }
                matrix[carRow][carCol] = 'C';
                kilometersPassed += 20;
            }

            if (matrix[carRow][carCol] == 'F') {
                matrix[carRow][carCol] = 'C';
                hasFinished = true;
                break;
            }


            command = scanner.nextLine();
        }


        if (hasFinished) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }


        System.out.printf("Distance covered %d km.%n", kilometersPassed);

        Arrays.stream(matrix).iterator().forEachRemaining(System.out::println);
    }

    private static boolean isValidRow(char[][] matrix, int row) {
        return row >= 0 && row < matrix.length;
    }

    private static boolean isValidCol(char[][] matrix, int row, int col) {
        return col >= 0 && col < matrix[row].length;
    }


}
