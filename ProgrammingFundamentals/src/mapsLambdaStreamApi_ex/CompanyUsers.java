package mapsLambdaStreamApi_ex;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> companies = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandLine = command.split(" -> ");
            String companyName = commandLine[0];
            String employeeId = commandLine[1];

            companies.putIfAbsent(companyName, new ArrayList<>());

            if (!companies.get(companyName).contains(employeeId)) {
                companies.get(companyName).add(employeeId);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {

            System.out.printf("%s%n", entry.getKey());
            for (String element : entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }
    }
}
