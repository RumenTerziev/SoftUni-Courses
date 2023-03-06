package regularExpressionsEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racerNamesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> racers = new LinkedHashMap<>();

        String inputText = scanner.nextLine();
        while (!inputText.equals("end of race")) {
            StringBuilder racerName = new StringBuilder();


            Pattern patternLetters = Pattern.compile("[A-Za-z]+");

            Pattern patternDigits = Pattern.compile("[0-9]");


            Matcher fullName = patternLetters.matcher(inputText);

            while (fullName.find()) {
                racerName.append(fullName.group());

            }
            String currentRacer = racerName.toString();

            int distance = 0;

            Matcher allDigits = patternDigits.matcher(inputText);

            while (allDigits.find()) {
                distance += Integer.parseInt(allDigits.group());
            }


            if (racerNamesList.contains(currentRacer)) {
                racers.putIfAbsent(currentRacer, 0);
                racers.put(currentRacer, racers.get(currentRacer) + distance);
            }

            inputText = scanner.nextLine();
        }


        List<String> namesOfFirstThree = racers.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n", namesOfFirstThree.get(0));
        System.out.printf("2nd place: %s%n", namesOfFirstThree.get(1));
        System.out.printf("3rd place: %s%n", namesOfFirstThree.get(2));

    }
}
