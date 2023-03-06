package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class bombNumbers_0501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bombNumberAndPower = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bombNum = bombNumberAndPower[0];
        int power = bombNumberAndPower[1];

        int sum = 0;

        while (numbers.contains(bombNum)) {
            int elementIndex = numbers.indexOf(bombNum);
            int left = Math.max(0, elementIndex - power);
            int right = Math.min(elementIndex + power, numbers.size() - 1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        for (int element : numbers) {
            sum = sum + element;

        }
        System.out.println(sum);
    }
}
