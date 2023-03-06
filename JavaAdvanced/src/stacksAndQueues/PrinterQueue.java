package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {

                    System.out.printf("Canceled %s%n", printerQueue.poll());
                }
            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String text : printerQueue) {
            System.out.println(text);
        }
    }
}
