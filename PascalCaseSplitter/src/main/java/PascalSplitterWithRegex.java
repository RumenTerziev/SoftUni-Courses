import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PascalSplitterWithRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> words = new ArrayList<>();

        Pattern pattern = Pattern.compile("([A-Z][a-z]*)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            String currentWord = matcher.group();

            words.add(currentWord);

        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
