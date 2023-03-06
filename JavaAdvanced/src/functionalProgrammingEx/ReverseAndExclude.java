package functionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numberToDivide = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisible = n -> n % numberToDivide == 0;

        Collections.reverse(numbers);

        numbers.removeIf(isDivisible);

        numbers.forEach(n -> System.out.printf("%d ", n));
    }
}
