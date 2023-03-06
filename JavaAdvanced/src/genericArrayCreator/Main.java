package genericArrayCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] arrTwo = ArrayCreator.create(Integer.class, 5, 0);


        String[] strings = ArrayCreator.create(5, "none");

        Integer[] array = ArrayCreator.create(Integer.class, 5, 0);


        for (String string : strings) {
            System.out.println(string + "");
        }

        for (int item : array) {
            System.out.println(item + "");
        }
    }
}
