package functionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maximumLength = Integer.parseInt(scanner.nextLine());

        String[] namesToCheck = scanner.nextLine().split("\\s+");

        Predicate<String> lengthChecker = s -> s.length() <= maximumLength;

        Arrays.stream(namesToCheck).filter(lengthChecker).forEach(System.out::println);
    }
}
