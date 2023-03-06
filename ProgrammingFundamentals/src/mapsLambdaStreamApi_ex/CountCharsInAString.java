package mapsLambdaStreamApi_ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> characterMap = new LinkedHashMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i <= text.length() - 1; i++) {
            char currentSymbol = text.toCharArray()[i];

            if (currentSymbol != ' ') {
                if (!characterMap.containsKey(currentSymbol)) {
                    characterMap.put(currentSymbol, 1);
                } else {
                    characterMap.put(currentSymbol, characterMap.get(currentSymbol) + 1);
                }
            }

        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
