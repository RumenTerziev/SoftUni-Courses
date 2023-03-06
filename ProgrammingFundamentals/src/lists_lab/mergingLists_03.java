package lists_lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();


        int minSize = Math.min(firstNumbers.size(), secondNumbers.size());

        for (int i = 0; i < minSize; i++) {
            int firstItem = firstNumbers.get(i);
            int secondItem = secondNumbers.get(i);

            resultList.add(firstItem);
            resultList.add(secondItem);

        }

        if (firstNumbers.size() > secondNumbers.size()) {
            resultList.addAll(firstNumbers.subList(minSize, firstNumbers.size()));
        } else {
            resultList.addAll(secondNumbers.subList(minSize, secondNumbers.size()));
        }

        for (int item : resultList) {
            System.out.print(item + " ");
        }
    }
}
