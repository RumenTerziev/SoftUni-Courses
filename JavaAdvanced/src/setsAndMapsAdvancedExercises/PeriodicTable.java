package setsAndMapsAdvancedExercises;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countRows = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueCompounds = new LinkedHashSet<>();

        while (countRows-- > 0) {

            String[] chemicalCompounds = scanner.nextLine().split("\\s+");

            uniqueCompounds.addAll(Arrays.asList(chemicalCompounds));

        }

        uniqueCompounds.stream().sorted(String::compareTo).forEach(e -> System.out.print(e + " "));

    }
}
