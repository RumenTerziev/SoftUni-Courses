package stacksAndQueues;

import java.util.*;

public class MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] childrenNames = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());
        List<String> childrenList = new ArrayList<>();

        childrenList.addAll(Arrays.asList(childrenNames));

        ArrayDeque<String> resultQueue = new ArrayDeque<>();

        int iterations = 1;
        int indexToManipulate = -1;
        while (childrenList.size() > 1) {

            for (int i = 1; i <= tosses; i++) {

                indexToManipulate++;
                if (indexToManipulate > childrenList.size() - 1) {
                    indexToManipulate = 0;

                }
            }

            int counter = 0;
            for (int i = 1; i <= iterations; i++) {
                if (iterations % i == 0) {
                    counter++;
                }
            }


            StringBuilder resultBuilder = new StringBuilder();

            if (counter == 1 || counter > 2) {


                resultBuilder.append("Removed ").append(childrenList.get(indexToManipulate));
                resultQueue.offer(resultBuilder.toString());
                childrenList.remove(indexToManipulate);


            } else {
                resultBuilder.append("Prime ").append(childrenList.get(indexToManipulate));
                resultQueue.offer(resultBuilder.toString());
            }

            indexToManipulate--;
            iterations++;
        }


        for (String currentElement : resultQueue) {
            System.out.println(currentElement);
        }

        System.out.printf("Last is %s", childrenList.get(0));


    }
}
