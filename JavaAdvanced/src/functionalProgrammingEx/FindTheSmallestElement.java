package functionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findMin = integers -> {
            int min = Integer.MAX_VALUE;
            int indexMin = -1;

            for (int i = 0; i < integers.size(); i++) {
                if (integers.get(i) <= min) {
                    min = integers.get(i);
                    indexMin = i;
                }
            }
            return indexMin;
        };


        System.out.println(findMin.apply(numbers));


//        Function<List<Integer>, Integer> alternative = list -> {
//            int min = list.stream().mapToInt(e -> e).min().getAsInt();
//            return list.lastIndexOf(min);
//        };
//
//        System.out.println(alternative.apply(numbers));
    }
}
