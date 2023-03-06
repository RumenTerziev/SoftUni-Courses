import java.util.Scanner;

public class SumOfTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startPoint = Integer.parseInt(scanner.nextLine());
        int finalPoint = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());


        int sum = 0;
        int firstNum = 0;
        int secondNum = 0;
        int countCombination = 0;
        boolean isMagic = false;
        for (int i = startPoint; i <= finalPoint; i++) {
            for (int j = startPoint; j <= finalPoint; j++) {
                sum = i + j;
                countCombination++;
                if (sum == magicNumber) {
                    isMagic = true;
                    firstNum = i;
                    secondNum = j;
                    break;
                }

            }
            if (isMagic) {
                break;
            }
        }
        if (isMagic) {
            System.out.printf("Combination N:%d (%d + %d = %d)", countCombination, firstNum, secondNum, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", countCombination, magicNumber);
        }
    }
}
