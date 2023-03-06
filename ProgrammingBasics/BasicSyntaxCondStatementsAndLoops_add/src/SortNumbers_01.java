import java.util.Scanner;

public class SortNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());


        if (firstNumber >= secondNumber && secondNumber >= thirdNumber) {
            System.out.printf("%d%n%d%n%d", firstNumber, secondNumber, thirdNumber);
        } else if (firstNumber >= thirdNumber && thirdNumber >= secondNumber) {
            System.out.printf("%d%n%d%n%d", firstNumber, thirdNumber, secondNumber);
        } else if (secondNumber >= firstNumber && firstNumber >= thirdNumber) {
            System.out.printf("%d%n%d%n%d", secondNumber, firstNumber, thirdNumber);
        } else if (secondNumber >= thirdNumber) {
            System.out.printf("%d%n%d%n%d", secondNumber, thirdNumber, firstNumber);
        } else if (firstNumber >= secondNumber) {
            System.out.printf("%d%n%d%n%d", thirdNumber, firstNumber, secondNumber);
        } else {
            System.out.printf("%d%n%d%n%d", thirdNumber, secondNumber, firstNumber);
        }
    }
}
