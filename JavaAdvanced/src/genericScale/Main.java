package genericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        Scale<String> stringScale = new Scale<>(first, second);
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(10, 10);
        System.out.println(integerScale.getHeavier());


    }
}
