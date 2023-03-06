import java.util.Arrays;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(scanner.nextLine());

        int [] numbersToIndex = new int[index + 1];
        int [] numbersAfterIndex = new int[numbers.length - index -1];

        for (int i = 0; i <= index; i++) {
            int currentElement = numbers[i];
            numbersToIndex[i] = currentElement;
        }
        for (int i = index + 1; i <= numbers.length - 1; i++) {
            int currentElement = numbers[i];
            numbersAfterIndex[i - index - 1] = currentElement;
        }
        int [] exchangedNumbers = new int[numbers.length];

        for (int i = 0; i <= numbersAfterIndex.length -1; i++) {
            exchangedNumbers[i] = numbersAfterIndex[i];
        }
        for (int i = numbersAfterIndex.length; i <= exchangedNumbers.length - 1; i++) {
            exchangedNumbers[i] = numbersToIndex[i - numbersAfterIndex.length];
        }

        numbers = exchangedNumbers;

        for (int item : numbers) {
            System.out.print(item + " ");
        }
    }
}
