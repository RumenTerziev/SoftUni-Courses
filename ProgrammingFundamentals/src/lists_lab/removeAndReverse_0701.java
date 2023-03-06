package lists_lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class removeAndReverse_0701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i <= numbersList.size() - 1; i++) {
            if (numbersList.get(i) < 0) {
                numbersList.remove(i);
                i -= 1;
            }
        }
        Collections.reverse(numbersList);
        if (numbersList.isEmpty()) {
            System.out.println("empty");
        } else {
            for (int element : numbersList) {
                System.out.print(element + " ");
            }
        }
    }
}
