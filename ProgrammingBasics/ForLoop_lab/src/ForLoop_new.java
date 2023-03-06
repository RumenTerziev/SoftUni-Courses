import java.util.Scanner;

public class ForLoop_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

            int oddSum = 0;
            int evenSum = 0;

        for (int num = 1; num <= n; num++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (num % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        if (evenSum == oddSum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
