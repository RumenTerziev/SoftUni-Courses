package setsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);

            if (!symbolsMap.containsKey(currentSymbol)) {
                symbolsMap.put(currentSymbol, 1);
            } else {
                symbolsMap.put(currentSymbol, symbolsMap.get(currentSymbol) + 1);
            }

        }

        symbolsMap.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
