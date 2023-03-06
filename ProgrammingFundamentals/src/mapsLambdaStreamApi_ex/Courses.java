package mapsLambdaStreamApi_ex;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> courses = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandLine = command.split(" : ");
            String courseName = commandLine[0];
            String user = commandLine[1];

            courses.putIfAbsent(courseName, new ArrayList<>());

            if (!courses.get(courseName).contains(user)) {
                courses.get(courseName).add(user);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String element : entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }
    }
}
