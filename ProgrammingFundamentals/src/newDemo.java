import java.util.Arrays;
import java.util.Scanner;

public class newDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(scanner.nextLine());




        String firstEvenNumbers = "";

        for (int i = 0; i <= numbers.length - 1; i++) {
            int currentElement = numbers[i];
            if (numbers[i] % 2 == 0) {
                firstEvenNumbers = firstEvenNumbers + "" + currentElement + " ";
            }
        }

        int [] firstCountEvenNumbers = Arrays.stream(firstEvenNumbers.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("[");

        for (int i = 0; i <= firstCountEvenNumbers.length - 1; i++) {
            if (i != firstCountEvenNumbers.length - 1) {
                System.out.print(firstCountEvenNumbers[i] + ", ");
            } else {
                System.out.print(firstCountEvenNumbers[i] + "]");
            }
        }
    }
}
