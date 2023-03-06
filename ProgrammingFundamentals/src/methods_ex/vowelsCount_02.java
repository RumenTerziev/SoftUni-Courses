package methods_ex;

import java.util.Scanner;

public class vowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        System.out.println(findVowelsCount(input));


    }

    public static int findVowelsCount(String text) {


        int countVowel = 0;
        for (int position = 0; position <= text.length() - 1; position++) {
            char currentSymbol = text.charAt(position);

            switch (currentSymbol) {
                case 'a':
                case 'A':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                    countVowel++;
                    break;
            }
        }

        return countVowel;
    }
}
