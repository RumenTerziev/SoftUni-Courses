import java.util.Scanner;

public class StrongNum_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int startNum = num;

        int sumFact = 0;
        while (num > 0) {
            int currentDigit = num % 10;

            int fact = 1;
            for (int i = 1; i <= currentDigit; i++) {
                fact = fact * i;
            }

            sumFact = sumFact + fact;
            num = num / 10;

        }
        if (sumFact == startNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
