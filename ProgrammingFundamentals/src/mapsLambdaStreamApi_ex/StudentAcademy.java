package mapsLambdaStreamApi_ex;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> map = new LinkedHashMap<>();


        for (int i = 0; i < n * 2; i += 2) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());


            if (!map.containsKey(name)) {
                map.put(name, grade);
            } else {
                map.put(name, (map.get(name) + grade) / 2);
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
