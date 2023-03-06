import java.util.Scanner;

public class reverseString_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = "";
        for (int position = input.length() - 1; position >= 0; position--) {
            char currentSymbol = input.charAt(position);
            result = result + currentSymbol;
        }
        System.out.println(result);
    }
}
