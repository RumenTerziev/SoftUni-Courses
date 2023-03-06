package textProcessingEx;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNum = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        if (secondNum == 0) {
            System.out.println("0");
        } else if (secondNum > 0) {

            int tens = 0;
            for (int i = firstNum.length() - 1; i >= 0; i--) {
                int lastDigit = Integer.parseInt(firstNum.charAt(i) + "");
                int resultLast = lastDigit * secondNum + tens;
                tens = 0;
                if (resultLast >= 0 && resultLast <= 9) {
                    sb.append(resultLast);
                } else if (resultLast > 9) {
                    tens = resultLast / 10;
                    resultLast = resultLast % 10;
                    sb.append(resultLast);
                }
            }
            if (tens > 0) {
                sb.append(tens);
            }

            sb.reverse();


            if (sb.charAt(0) != '0') {
                System.out.println(sb);
            } else if (sb.charAt(0) == '0') {


                int startIndex = 0;
                int endIndex = 0;

                for (int i = 1; i <= sb.length() - 1; i++) {
                    if (sb.charAt(i) != '0') {
                        endIndex = i;
                        break;
                    }
                }

                String result = sb.toString().replaceAll(sb.substring(startIndex, endIndex), "");
                System.out.println(result);
            }

        }

    }
}