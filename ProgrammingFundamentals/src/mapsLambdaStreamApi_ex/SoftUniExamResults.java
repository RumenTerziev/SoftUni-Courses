package mapsLambdaStreamApi_ex;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();


        int countSubmissions = 0;
        String command = scanner.nextLine();
        while (!command.equals("exam finished")) {

            String[] commandLine = command.split("-");
            String user = commandLine[0];
            String language = commandLine[1];


            if (!language.equals("banned")) {
                int points = Integer.parseInt(commandLine[2]);
                results.putIfAbsent(user, new ArrayList<>());
                results.get(user).add(points);
                results.put(user, results.get(user));

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            } else {
                results.remove(user);
            }


            command = scanner.nextLine();
        }

        System.out.println("Results:");
        results.forEach((key, value) -> System.out.printf("%s | %d%n", key, Collections.max(value)));
        System.out.println("Submissions:");
        submissions.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }
}
