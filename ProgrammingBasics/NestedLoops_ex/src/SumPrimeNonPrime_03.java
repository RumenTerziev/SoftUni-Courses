import java.util.Scanner;

public class SumPrimeNonPrime_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        int primeNumSum = 0;
        int nonPrimeNumSum = 0;
        while (!command.equals("stop")) {
            int currentNum = Integer.parseInt(command);

            if (currentNum < 0) {
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }

            int dividerCount = 0;
            for (int i = 1; i <= currentNum; i++) {
                if (currentNum % i == 0) {
                    dividerCount++;
                }
            }
            if (dividerCount == 2) {
                primeNumSum = primeNumSum + currentNum;
            } else {
                nonPrimeNumSum = nonPrimeNumSum + currentNum;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeNumSum);
        System.out.printf("Sum of all non prime numbers is: %d%n", nonPrimeNumSum);

    }
}
