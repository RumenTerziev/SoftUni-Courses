package regularExpressionsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");


        for (int i = 0; i <= demonNames.length - 1; i++) {
            String demon = demonNames[i];


            Pattern patternForHealth = Pattern.compile("[^+\\-\\.*\\/\\d, ]");
            Pattern patternForDamage = Pattern.compile("(-?\\d+\\.?\\d*)");


            Matcher matcherForHealth = patternForHealth.matcher(demon);

            int health = 0;
            while (matcherForHealth.find()) {
                char currentSymbol = matcherForHealth.group().charAt(0);
                health += currentSymbol;
            }


            Matcher matcherForDamage = patternForDamage.matcher(demon);

            double damage = 0;
            while (matcherForDamage.find()) {

                String currentNum = matcherForDamage.group();

                if (!Character.isDigit(currentNum.charAt(0))) {
                    if (currentNum.charAt(0) == '-') {
                        double currentDamage = Double.parseDouble(currentNum.replace('-', ' ').trim());
                        damage = damage - currentDamage;

                    } else if (currentNum.charAt(0) == '+') {
                        double currentDamage = Double.parseDouble(currentNum.replace('+', ' ').trim());
                        damage = damage + currentDamage;
                    }
                } else if (Character.isDigit(currentNum.charAt(0))) {
                    double currentDamage = Double.parseDouble(currentNum);
                    damage = damage + currentDamage;
                }

            }

            for (int j = 0; j <= demon.length() - 1; j++) {
                char currentSymbol = demon.charAt(j);
                if (currentSymbol == '*') {

                    damage = damage * 2;

                } else if (currentSymbol == '/') {
                    if (damage != 0) {
                        damage = damage / 2;
                    }
                }
            }


            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }

    }
}
