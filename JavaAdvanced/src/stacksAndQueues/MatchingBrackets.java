package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {

            char currentSymbol = input.charAt(index);

            if (currentSymbol == '(') {
                stack.push(index);
            } else if (currentSymbol == ')') {
                int startIndex = stack.pop();
                String expression = input.substring(startIndex, index + 1);
                System.out.println(expression);
            }
        }

    }
}
