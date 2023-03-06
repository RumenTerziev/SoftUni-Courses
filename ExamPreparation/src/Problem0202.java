import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem0202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(#|@)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> resultList = new ArrayList<>();
        int countPairs = 0;
        int countMirrorWords = 0;

        while (matcher.find()) {
            countPairs++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            StringBuilder secondWordBuilder = new StringBuilder(secondWord);
            String reversedSecondWord = secondWordBuilder.reverse().toString();

            if (firstWord.equals(reversedSecondWord)) {
                countMirrorWords++;
                resultList.add(firstWord + " <=> " + secondWord);
            }
        }

        if (countPairs > 0) {
            System.out.printf("%d word pairs found!%n", countPairs);
        } else {
            System.out.println("No word pairs found!");
        }
        if (countMirrorWords > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", resultList));
        } else {
            System.out.println("No mirror words!");
        }

    }
}
