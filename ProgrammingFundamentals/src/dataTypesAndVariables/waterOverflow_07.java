package dataTypesAndVariables;

import java.util.Scanner;

public class waterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short countInfusions = Short.parseShort(scanner.nextLine());
        int totalLiters = 0;
        for (int i = 1; i <= countInfusions; i++) {
            int currentLiters = Integer.parseInt(scanner.nextLine());
            if (totalLiters + currentLiters <= 255) {
                totalLiters = totalLiters + currentLiters;
            } else {
                System.out.println("Insufficient capacity!");
            }

        }
        System.out.println(totalLiters);
    }
}
