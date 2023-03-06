package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class bombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bombNumberAndPower = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bombNum = bombNumberAndPower[0];
        int power = bombNumberAndPower[1];
        int indexBombNum = -1;
        int sum = 0;
        int countBombed = 0;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            if (numbers.get(i) == bombNum) {
                indexBombNum = i;
                countBombed++;
            }
        }
        if (indexBombNum != -1) {
            if (indexBombNum - power >= 0 && indexBombNum + power <= numbers.size() - 1) {
                int countDamagedNumbers = power * 2 + 1;
                for (int i = indexBombNum - power; i <= countDamagedNumbers; i++) {
                    numbers.remove(i);
                    i -= 1;
                    countDamagedNumbers--;
                    if (countDamagedNumbers == 0) {

                    }
                }
            } else if (indexBombNum - power < 0) {
                int countDamaged = (2 * power + 1 - (Math.abs(-(indexBombNum - power))));
                for (int i = 0; i <= indexBombNum + power; i++) {
                    numbers.remove(i);
                    i -= 1;
                    countDamaged--;
                    if (countDamaged == 0) {

                    }
                }
            } else if (indexBombNum + power > numbers.size() - 1) {
                int countDamaged = (2 * power + 1 - (indexBombNum + power - numbers.size() - 1));
                for (int i = indexBombNum - power; i <= numbers.size() - 1; i++) {
                    numbers.remove(i);
                    i -= 1;
                    countDamaged--;
                    if (countDamaged == 0) {

                    }
                }
            }
        }
        for (int i = 0; i <= numbers.size() - 1; i++) {
            sum = sum + numbers.get(i);
        }
        System.out.println(sum);
    }
}
