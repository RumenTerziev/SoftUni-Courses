package stacksAndQueues;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int countTosses = Integer.parseInt(scanner.nextLine());
        List<String> children = new ArrayList<>(Arrays.asList(input));
        ArrayDeque<String> removedChildren = new ArrayDeque<>();

        int indexToRemove = -1;
        while (children.size() > 1) {


            for (int i = 1; i <= countTosses; i++) {

                indexToRemove++;
                if (indexToRemove > children.size() - 1) {
                    indexToRemove = 0;
                }
            }


            removedChildren.offer(children.get(indexToRemove));
            children.remove(indexToRemove);

            indexToRemove--;


        }


        for (String removedChild : removedChildren) {
            System.out.printf("Removed %s%n", removedChild);
        }

        System.out.printf("Last is %s", children.get(0));


    }
}
