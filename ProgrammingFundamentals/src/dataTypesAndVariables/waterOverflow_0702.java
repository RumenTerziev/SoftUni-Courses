package dataTypesAndVariables;

import java.util.Scanner;

public class waterOverflow_0702 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInfusions = Integer.parseInt(scanner.nextLine());

        int currentInfusion = 1;
        int totalLiters = 0;
        while (currentInfusion <= countInfusions) {
            int currentLiters = Integer.parseInt(scanner.nextLine());
            if (totalLiters + currentLiters <= 255) {
                totalLiters = totalLiters + currentLiters;
            } else {
                System.out.println("Insufficient capacity!");
            }
            currentInfusion++;
        }
        System.out.println(totalLiters);
    }
}
