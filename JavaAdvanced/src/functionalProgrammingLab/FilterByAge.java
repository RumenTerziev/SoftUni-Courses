package functionalProgrammingLab;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNames = Integer.parseInt(scanner.nextLine());


        Function<Scanner, Person> readPerson = sc -> {
            String[] data = scanner.nextLine().split(",\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };

        List<Person> people = IntStream.range(0, countNames).mapToObj(i -> readPerson.apply(scanner)).collect(Collectors.toList());


        String conditionToFilter = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String formatToPrint = scanner.nextLine();


        Predicate<Person> filter = getFilter(conditionToFilter, ageFilter);

        people.stream().filter(filter).forEach(person -> {
            printer(person.getName(), person.getAge(), formatToPrint);
        });


    }

    private static Predicate<Person> getFilter(String conditionToFilter, int ageFilter) {

        switch (conditionToFilter) {

            case "younger":

                return person -> person.getAge() <= ageFilter;

            case "older":
                return person -> person.getAge() >= ageFilter;

            default:
                throw new IllegalArgumentException("IllegalArgumentException");
        }

    }


    private static void printer(String name, int age, String format) {

        switch (format) {

            case "name age":
                System.out.printf("%s - %d%n", name, age);
                break;
            case "name":
                System.out.printf("%s%n", name);
                break;
            case "age":
                System.out.printf("%d%n", age);
                break;
        }
    }
}
