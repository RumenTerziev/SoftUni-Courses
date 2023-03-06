package functionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int lowerBound = inputData[0];
        int upperBound = inputData[1];

        String condition = scanner.nextLine();

        IntPredicate evenOrOdd = n -> condition.equals("odd") == (n % 2 != 0);

        IntStream.rangeClosed(lowerBound, upperBound).filter(evenOrOdd).forEach(n -> System.out.print(n + " "));


    }
}
