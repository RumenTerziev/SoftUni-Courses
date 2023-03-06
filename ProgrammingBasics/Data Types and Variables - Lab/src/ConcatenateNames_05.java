import java.util.Scanner;

public class ConcatenateNames_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = String.format("%s" + delimiter + "%s", name, lastName);

        System.out.println(result);
    }
}
