import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(stack::push);


        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int maximumMilligramsPerNight = 300;
        int caffeineDrankForTheNight = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {


            int currentCaffeine = 0;

            if (notNull(stack.peek()) && notNull(queue.peek())) {

                currentCaffeine = stack.peek() * queue.peek();
            }

            if (caffeineDrankForTheNight + currentCaffeine <= maximumMilligramsPerNight) {
                caffeineDrankForTheNight += currentCaffeine;
                if (notNull(stack.peek()) && notNull(queue.peek())) {
                    stack.pop();
                    queue.poll();
                }
            } else {

                if (notNull(stack.peek())) {
                    stack.pop();
                }

                if (notNull(queue.peek())) {
                    queue.offer(queue.poll());
                }


                caffeineDrankForTheNight -= 30;

            }

            if (caffeineDrankForTheNight < 0) {
                caffeineDrankForTheNight = 0;
            }


        }

        if (!queue.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Drinks left: ");

            for (int element : queue) {
                stringBuilder.append(element);
                stringBuilder.append(", ");
            }

            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
            System.out.println(stringBuilder);

        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineDrankForTheNight);

    }


    private static boolean notNull(Integer number) {
        return number != null;
    }
}
