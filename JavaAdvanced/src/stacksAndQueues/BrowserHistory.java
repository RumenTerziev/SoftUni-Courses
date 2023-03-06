package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String currentUrl = null;

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (historyStack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = historyStack.pop();
                }
            } else {
                if (currentUrl != null) {
                    historyStack.push(currentUrl);
                }
                currentUrl = input;
            }

            System.out.println(currentUrl);
            input = scanner.nextLine();
        }
    }
}
