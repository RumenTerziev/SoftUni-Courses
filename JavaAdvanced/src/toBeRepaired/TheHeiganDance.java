package toBeRepaired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());

        double playerHitPoints = 18500;
        double bossHitPoints = 3000000;

        int playerRow = 7;
        int playerCol = 7;
        int initialRow = playerRow;
        int initialCol = playerCol;

        int size = 15;


        char[][] matrix;

        matrix = buildMatrix(size);

        int turn = 0;
        List<String> spells = new ArrayList<>();

        while (bossHitPoints > 0 && playerHitPoints > 0) {
            String[] spellInfo = scanner.nextLine().split("\\s+");
            String castedSpell = spellInfo[0];
            int affectedRow = Integer.parseInt(spellInfo[1]);
            int affectedCol = Integer.parseInt(spellInfo[2]);


            spells.add(castedSpell);

            double damageBySpell = 0;
            switch (castedSpell) {

                case "Cloud":
                    if (turn - 1 > 0 && spells.get(turn - 1).equals("Cloud")) {
                        damageBySpell = 7000;
                    }
                    damageBySpell = 3500;
                    break;
                case "Eruption":


                    if (turn - 1 > 0 && spells.get(turn - 1).equals("Cloud")) {
                        damageBySpell = 9500;

                    } else {
                        damageBySpell = 6000;
                    }
                    break;
            }

            int startAffectedRow = -1;

            if (affectedRow - 1 < 0) {
                startAffectedRow = 0;
            } else {
                startAffectedRow = affectedRow - 1;
            }
            int endAffectedRow = -1;
            if (affectedRow + 1 > size - 1) {
                endAffectedRow = size - 1;
            } else {
                endAffectedRow = affectedRow + 1;
            }

            int startAffectedCol = -1;
            if (affectedCol - 1 < 0) {
                startAffectedCol = 0;
            } else {
                startAffectedCol = affectedCol - 1;
            }

            int endAffectedCol = -1;
            if (affectedCol + 1 > size - 1) {
                endAffectedCol = size - 1;
            } else {
                endAffectedCol = affectedCol + 1;
            }

            matrix = putAffectedArea(matrix, startAffectedRow, endAffectedRow, startAffectedCol, endAffectedCol);


            boolean willTakeDamage = false;
            int counter = 0;
            while (isAffected(matrix, playerRow, playerCol) && counter < 4) {

                if (counter == 0) {
                    if (isValidRow(playerRow - 1, size) && !isAffected(matrix, playerRow - 1, playerCol)) {
                        playerRow--;
                    }
                } else if (counter == 1) {
                    if (isValidCol(playerCol + 1, size) && !isAffected(matrix, playerRow, playerCol + 1)) {
                        playerCol++;
                    }
                } else if (counter == 2) {
                    if (isValidRow(playerRow + 1, size) && !isAffected(matrix, playerRow + 1, playerCol)) {
                        playerRow++;
                    }
                } else if (counter == 3) {
                    if (isValidCol(playerCol - 1, size) && !isAffected(matrix, playerRow, playerCol - 1)) {
                        playerCol--;
                    }
                }

                counter++;
            }

            if (isAffected(matrix, playerRow, playerCol)) {
                willTakeDamage = true;
                playerHitPoints -= damageBySpell;
            }


            if (turn - 1 > 0 && willTakeDamage && spells.get(turn - 1).equals("Cloud")) {
                playerHitPoints -= 3500;
            }

            matrix = buildMatrix(size);

            bossHitPoints -= damage;
            turn++;
        }

        if (bossHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %.0f%n", playerHitPoints);
        } else if (playerHitPoints <= 0) {
            System.out.printf("Heigan: %.2f%n", bossHitPoints);
            if (spells.get(spells.size() - 1).equals("Cloud")) {
                System.out.printf("Player: Killed by Plague %s%n", spells.get(spells.size() - 1));
            } else {
                System.out.printf("Player: Killed by %s%n", spells.get(spells.size() - 1));
            }
        }


        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isValidRow(int row, int size) {
        return row >= 0 && row < size;
    }

    private static boolean isValidCol(int col, int size) {
        return col >= 0 && col < size;
    }

    private static boolean isAffected(char[][] matrix, int playerRow, int playerCol) {
        return matrix[playerRow][playerCol] == 'A';
    }

    private static char[][] buildMatrix(int size) {

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = '-';
            }
        }
        return matrix;
    }

    private static char[][] putAffectedArea(char[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                matrix[row][col] = 'A';
            }
        }
        return matrix;
    }
}
