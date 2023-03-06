package dataTypesAndVariables;

import java.util.Scanner;

public class spiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());

        int totalSpices = 0;
        int countDays = 0;
        while (yield >= 100) {
            totalSpices = totalSpices + yield;


            countDays++;
            totalSpices = totalSpices - 26;
            yield = yield - 10;

        }
        if (totalSpices >= 26) {
            totalSpices = totalSpices - 26;
        } else {
            totalSpices = 0;
        }
        System.out.println(countDays);
        System.out.println(totalSpices);
    }
}
