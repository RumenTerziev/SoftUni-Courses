import java.util.Scanner;

public class ReadText_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            System.out.println(command);
            command = scanner.nextLine();
        }
    }
}
