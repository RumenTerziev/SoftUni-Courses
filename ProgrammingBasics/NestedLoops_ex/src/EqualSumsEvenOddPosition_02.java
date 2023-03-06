import java.util.Scanner;

public class EqualSumsEvenOddPosition_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        for (int i = numberOne; i <= numberTwo ; i++) {
                String currentNum = "" + i;
                int oddSum = 0;
                int evenSum = 0;
            for (int j = 0; j < currentNum.length() ; j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
                if (j % 2 == 0) {
                    evenSum = evenSum + currentDigit;
                } else {
                    oddSum = oddSum +  currentDigit;
                }

            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
