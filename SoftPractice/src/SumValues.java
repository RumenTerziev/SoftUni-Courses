import java.util.Scanner;

public class SumValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());


        int bestDivider = getBestDivider(firstNum, secondNum);
        int bestNum = getBestNum(firstNum, secondNum);



        if (bestDivider != Integer.MIN_VALUE && bestNum != 0) {
            System.out.println(bestDivider + bestNum);
        } else {
            System.out.println("Nothing found");
        }


    }

    private static int getBestNum(int firstNum, int secondNum) {

        int bestNum = 0;
        int bigger = getBiggerNum(firstNum, secondNum);

        for (int i = bigger; i <= firstNum * secondNum; i++) {

            if (i % firstNum == 0 && i % secondNum == 0) {
                bestNum = i;
                break;
            }

        }
        return bestNum;
    }

    private static int getBestDivider(int firstNum, int secondNum) {

        int bestDivider = Integer.MIN_VALUE;
        int bigger = getBiggerNum(firstNum, secondNum);

        for (int divider = 1; divider <= bigger; divider++) {

            if (firstNum % divider == 0 && secondNum % divider == 0) {
                bestDivider = divider;
            }
        }
        return bestDivider;
    }

    private static int getBiggerNum (int first, int second) {
        return Math.max(first, second);
    }
}
