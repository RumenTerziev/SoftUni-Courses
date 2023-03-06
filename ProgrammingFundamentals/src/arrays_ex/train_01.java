package arrays_ex;

import java.util.Scanner;

public class train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbersArr = new int[n];

        int sum = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            int countPeople = Integer.parseInt(scanner.nextLine());
            numbersArr[i] = countPeople;
            sum = sum + countPeople;
        }
        for (int element : numbersArr) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(sum);

    }
}
