package setsAndMapsAdvancedExercises;

import java.util.*;
import java.util.function.Predicate;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsLength = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int firsSetLength = setsLength[0];
        int secondLength = setsLength[1];

        Set<Integer> firsSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int index = 0; index < firsSetLength; index++) {
            int currentElement = Integer.parseInt(scanner.nextLine());

            firsSet.add(currentElement);
        }

        for (int index = 0; index < secondLength; index++) {
            int currentElement = Integer.parseInt(scanner.nextLine());

            secondSet.add(currentElement);
        }


        Predicate<Integer> predicate = e -> {
            for (int element : secondSet) {
                if (e == element) {
                    return true;
                }
            }
            return false;
        };

        firsSet.stream().filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
