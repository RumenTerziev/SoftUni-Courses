package textProcessing;

import java.util.Scanner;

public class repeatString_03 {
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


            for (int j = 0; j < count; j++) {
                resultString.append(currentText);
            }
        }

        System.out.println(resultString);
    }
}
