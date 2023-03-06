package dataTypesAndVariables;

import java.util.Scanner;

public class pokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int startingPokePower = pokePower;

        int countPokes = 0;
        while (pokePower >= distance) {
            pokePower = pokePower - distance;
            countPokes++;
            if (pokePower == startingPokePower * 0.5) {
                if (exhaustionFactor > 0) {
                    pokePower = pokePower / exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(countPokes);
    }
}
