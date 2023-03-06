package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPLayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstPLayer.size() != 0 && secondPlayer.size() != 0) {

            int firstPlayerCard = firstPLayer.get(0);
            int secondPlayerCard = secondPlayer.get(0);

            firstPLayer.remove(0);
            secondPlayer.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPLayer.add(firstPlayerCard);
                firstPLayer.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayerCard);
            }
        }

        if (firstPLayer.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayer));
        } else {
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPLayer));
        }

    }

    private static Integer getCardsSum(List<Integer> cardsList) {
        int sum = 0;

        for (int card : cardsList) {
            sum += card;
        }
        return sum;
    }
}
