package textProcessing;

import java.util.Scanner;

public class repeatString_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textArr = scanner.nextLine().split(" ");
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i <= textArr.length - 1; i++) {
            String currentText = textArr[i];

            int count = 0;
            for (int j = 0; j <= currentText.length() - 1; j++) {
                count++;
            }


            resultString.append(currentText.repeat(Math.max(0, count)));
        }

        System.out.println(resultString);
    }
}
