package functionalProgrammingEx;

import java.util.*;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        UnaryOperator<List<Integer>> addOperator = numbers -> numbers.stream().map(n -> n + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyOperator = numbers -> numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractOperator = numbers -> numbers.stream().map(n -> n - 1).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {

                case "add":
                    integerList = addOperator.apply(integerList);
                    break;
                case "multiply":
                    integerList = multiplyOperator.apply(integerList);
                    break;
                case "subtract":
                    integerList = subtractOperator.apply(integerList);
                    break;
                case "print":
                    integerList.forEach(element -> System.out.printf("%d ", element));
                    System.out.println();
                    break;

            }

            command = scanner.nextLine();
        }

    }
}
