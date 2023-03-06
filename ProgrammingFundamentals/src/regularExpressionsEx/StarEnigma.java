package regularExpressionsEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMessages = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < countMessages; i++) {

            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = decryptMessage(encryptedMessage);

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*:[\\d]+[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->[\\d]+[^@\\-!:>]*");
            Matcher matcher = pattern.matcher(decryptedMessage);


            while (matcher.find()) {

                String planetName = matcher.group("name");

                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }

            }


        }
        Collections.sort(attackedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.forEach(entry -> System.out.printf("-> %s%n", entry));

        Collections.sort(destroyedPlanets);
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.forEach(entry -> System.out.printf("-> %s%n", entry));
    }

    private static String decryptMessage(String encryptedMessage) {

        StringBuilder decryptedBuilder = new StringBuilder();
        for (char currentSymbol : encryptedMessage.toCharArray()) {
            int codeOfSymbol = currentSymbol - countSpecialSymbols(encryptedMessage);
            char resultSymbol = (char) codeOfSymbol;
            decryptedBuilder.append(resultSymbol);
        }
        return decryptedBuilder.toString();
    }

    private static int countSpecialSymbols(String message) {

        int count = 0;
        for (int i = 0; i <= message.length() - 1; i++) {
            char currentSymbol = message.charAt(i);

            switch (currentSymbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;

            }
        }
        return count;
    }

}
