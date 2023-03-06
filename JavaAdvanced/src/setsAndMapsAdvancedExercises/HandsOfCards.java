package setsAndMapsAdvancedExercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {

            String[] playerInfo = command.split(": ");
            String player = playerInfo[0];
            String[] playerHand = playerInfo[1].split(",\\s+");


            if (!playersMap.containsKey(player)) {
                playersMap.put(player, new LinkedHashSet<>());
                playersMap.get(player).addAll(Arrays.asList(playerHand));
            } else {
                playersMap.get(player).addAll(Arrays.asList(playerHand));
            }


            command = scanner.nextLine();
        }


        playersMap.forEach((key, value) -> {

            int currentSumOfCards = 0;
            for (String currentCard : value) {
                String cardType = currentCard.substring(0, currentCard.length() - 1);
                char multiplierSymbol = currentCard.charAt(currentCard.length() - 1);

                int power = cardPower(cardType);
                int multiplierFactor = multiplier(multiplierSymbol);

                currentSumOfCards += power * multiplierFactor;
            }

            System.out.printf("%s: %d%n", key, currentSumOfCards);
        });

    }

    private static int cardPower(String card) {

        switch (card) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return -1;
        }

    }

    private static int multiplier(char symbol) {

        switch (symbol) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return -1;
        }
    }
}
