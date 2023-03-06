import java.util.Scanner;

public class concatenateNames_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = String.format("%s%s%s", name, delimiter, lastName);

        System.out.println(result);
    }
}
