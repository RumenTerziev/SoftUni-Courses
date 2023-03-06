import java.util.Scanner;

public class HalfSumElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num = 1; num <= n; num++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number > max) {
                max = number;
            }
            sum = sum + number;
        }
        int sumWithoutMax = sum - max;
        if (sumWithoutMax == max) {
            System.out.printf("Yes\n" +
                    "Sum = %d\t", sumWithoutMax);
        } else {
            System.out.printf("No\n" +
                    "Diff = %d", Math.abs(sumWithoutMax - max));
        }

    }
}
