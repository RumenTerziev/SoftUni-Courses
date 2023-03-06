package stacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {

            ArrayDeque<Character> charactersStack = new ArrayDeque<>();

            boolean isBalanced = true;
            for (int i = 0; i < input.length(); i++) {
                char currentSymbol = input.charAt(i);

                switch (currentSymbol) {
                    case '{':
                    case '(':
                    case '[':
                        charactersStack.push(currentSymbol);
                        break;
                    case '}':
                        if (charactersStack.pop() != '{') {
                            isBalanced = false;
                            break;
                        }
                        break;
                    case ')':
                        if (charactersStack.pop() != '(') {
                            isBalanced = false;
                            break;
                        }
                        break;
                    case ']':
                        if (charactersStack.pop() != '[') {
                            isBalanced = false;
                            break;
                        }
                        break;
                }

            }
            if (isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
