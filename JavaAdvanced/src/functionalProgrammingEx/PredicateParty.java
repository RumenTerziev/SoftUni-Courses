package functionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Party!")) {

            String[] commandLine = command.split("\\s+");
            String typeOfCommand = commandLine[0];
            String typeOfFilter = commandLine[1];
            String parameter = commandLine[2];


            Predicate<String> predicate = getPredicate(typeOfFilter, parameter);

            switch (typeOfCommand) {
                case "Remove":

                    assert predicate != null;
                    names.removeIf(predicate);


                    break;
                case "Double":

                    List<String> namesToDouble = new ArrayList<>();

                    assert predicate != null;
                    names.stream().filter(predicate).forEach(namesToDouble::add);
                    names.addAll(namesToDouble);

            }

            command = scanner.nextLine();

        }

        Collections.sort(names);

        if (!names.isEmpty()) {
            StringJoiner stringJoiner = new StringJoiner(", ");
            names.forEach(stringJoiner::add);
            System.out.println(stringJoiner + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String typeOfFilter, String parameter) {


        switch (typeOfFilter) {

            case "StartsWith":
                return p -> p.startsWith(parameter);

            case "EndsWith":
                return p -> p.endsWith(parameter);

            case "Length":
                int lengthToCheck = Integer.parseInt(parameter);
                return p -> p.length() == lengthToCheck;

        }

        return null;

    }
}
