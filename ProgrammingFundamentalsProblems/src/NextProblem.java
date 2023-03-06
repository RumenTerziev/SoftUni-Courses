import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NextProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int key = Integer.parseInt(scanner.nextLine());

        List<String> kids = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String encryptedMessage = command;

            StringBuilder decryptedMessage = new StringBuilder();
            for (int i = 0; i <= encryptedMessage.length() - 1; i++) {
                char currentSymbol = encryptedMessage.charAt(i);
                char decryptedSymbol = (char) (currentSymbol - key);
                decryptedMessage.append(decryptedSymbol);
            }


            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@:\\-!>]+!(?<behavior>[GN])!");
            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {

                String child = matcher.group("name");
                String behaviour = matcher.group("behavior");

                if (behaviour.equals("G")) {
                    kids.add(child);
                }
            }

            command = scanner.nextLine();
        }

        for (String element : kids) {
            System.out.println(element);
        }
    }
}
