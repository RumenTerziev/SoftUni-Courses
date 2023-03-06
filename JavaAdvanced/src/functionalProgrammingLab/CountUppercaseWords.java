package functionalProgrammingLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputText = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));

        Arrays.stream(inputText).filter(isUpperCase).forEach(queue::offer);

        System.out.println(queue.size());
        queue.forEach(System.out::println);
    }
}
