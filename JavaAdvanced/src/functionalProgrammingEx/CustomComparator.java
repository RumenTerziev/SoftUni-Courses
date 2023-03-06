package functionalProgrammingEx;

import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> custom = (first, second) -> {

            if (first % 2 == 0 && second % 2 != 0) {

                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {

                return first.compareTo(second);
            }
        };

        Arrays.sort(numbers, custom);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));

    }
}
