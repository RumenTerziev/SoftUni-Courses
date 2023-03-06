import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[a-zA-Z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        StringBuilder resultBuilder = new StringBuilder();

        int mirrorWords = 0;
        int countPairs = 0;
        while (matcher.find()) {

            countPairs++;
            StringBuilder secondWord = new StringBuilder(matcher.group("second"));
            String firstWord = matcher.group("first");
            if (firstWord.equals(secondWord.reverse().toString())) {
                mirrorWords++;

                resultBuilder.append(firstWord);
                resultBuilder.append(" <=> ");
                resultBuilder.append(secondWord.reverse());
                resultBuilder.append(", ");
            }
        }

        if (countPairs > 0) {
            System.out.printf("%d word pairs found!%n", countPairs);
        } else {
            System.out.println("No word pairs found!");
        }
        if (mirrorWords > 0) {
            System.out.println("The mirror words are:");
            System.out.println(resultBuilder.replace(resultBuilder.length() - 2, resultBuilder.length() - 1, ""));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
