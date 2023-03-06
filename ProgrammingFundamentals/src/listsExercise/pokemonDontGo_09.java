package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumRemoved = 0;
        while (!pokemonList.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());


            if (index >= 0 && index <= pokemonList.size() - 1) {
                int removedValue = pokemonList.get(index);
                pokemonList.remove(index);
                sumRemoved = sumRemoved + removedValue;

                for (int i = 0; i <= pokemonList.size() - 1; i++) {
                    if (pokemonList.get(i) <= removedValue) {
                        pokemonList.set(i, pokemonList.get(i) + removedValue);
                    } else if (pokemonList.get(i) > removedValue) {
                        pokemonList.set(i, pokemonList.get(i) - removedValue);
                    }
                }

            } else if (index < 0) {
                int valueOfFirstElement = pokemonList.get(0);
                sumRemoved = sumRemoved + valueOfFirstElement;
                pokemonList.set(0, pokemonList.get(pokemonList.size() - 1));

                for (int i = 0; i <= pokemonList.size() - 1; i++) {
                    if (pokemonList.get(i) <= valueOfFirstElement) {
                        pokemonList.set(i, pokemonList.get(i) + valueOfFirstElement);
                    } else if (pokemonList.get(i) > valueOfFirstElement) {
                        pokemonList.set(i, pokemonList.get(i) - valueOfFirstElement);
                    }
                }

            } else if (index > pokemonList.size() - 1) {

                int valueOfLastElement = pokemonList.get(pokemonList.size() - 1);
                sumRemoved = sumRemoved + valueOfLastElement;
                pokemonList.set(pokemonList.size() - 1, pokemonList.get(0));

                for (int i = 0; i <= pokemonList.size() - 1; i++) {
                    if (pokemonList.get(i) <= valueOfLastElement) {
                        pokemonList.set(i, pokemonList.get(i) + valueOfLastElement);
                    } else if (pokemonList.get(i) > valueOfLastElement) {
                        pokemonList.set(i, pokemonList.get(i) - valueOfLastElement);
                    }
                }
            }

        }
        System.out.println(sumRemoved);
    }
}
