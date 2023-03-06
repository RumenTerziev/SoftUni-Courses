package stacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int countOfCommands = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < countOfCommands; i++) {

            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];

            switch (command) {
                case "1":
                    int numberToPush = Integer.parseInt(commandLine[1]);
                    stack.push(numberToPush);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "3":
                    if (!stack.isEmpty()) {
                        System.out.println(Collections.max(stack));
                    } else {
                        System.out.println("asd");
                    }
                    break;
            }
        }
    }
}
