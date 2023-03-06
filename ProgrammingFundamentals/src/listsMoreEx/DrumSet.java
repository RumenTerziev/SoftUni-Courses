package listsMoreEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double initialMoney = Double.parseDouble(scanner.nextLine());
        List<Integer> drumsQuality = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i <= drumsQuality.size() - 1; i++) {
            newList.add(drumsQuality.get(i));
        }


        String command = scanner.nextLine();
        while (!command.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(command);


            for (int i = 0; i <= newList.size() - 1; i++) {


                if (newList.get(i) - power > 0) {
                    newList.set(i, newList.get(i) - power);
                } else if (newList.get(i) - power <= 0) {
                    if (initialMoney - (drumsQuality.get(i) * 3) >= 0) {
                        newList.set(i, drumsQuality.get(i));
                        initialMoney = initialMoney - (drumsQuality.get(i) * 3);
                    } else if (initialMoney - (drumsQuality.get(i) * 3) < 0) {
                        newList.remove(i);
                        drumsQuality.remove(i);
                        i = i - 1;


                    }
                }
            }


            command = scanner.nextLine();
        }

        for (int element : newList) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", initialMoney);
    }
}
