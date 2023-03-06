package functionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] newArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> getMin = integers -> Collections.min(Arrays.stream(newArray).collect(Collectors.toList()));

        System.out.println(getMin.apply(newArray));
    }
}
