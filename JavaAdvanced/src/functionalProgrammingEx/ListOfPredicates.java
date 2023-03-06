package functionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());

        int[] array = IntStream.rangeClosed(1, endNumber).toArray();

        int[] divisions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        IntPredicate isDivisible = integer -> {
            for (int element : divisions) {
                if (integer % element != 0) {
                    return false;
                }
            }

            return true;
        };


        Arrays.stream(array).filter(isDivisible).forEach(e -> System.out.print(e + " "));
    }
}
