import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }
        String currentPass = scanner.nextLine();
        int counter = 0;
        while (!currentPass.equals(password)) {
            counter++;
            if (counter >= 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            currentPass = scanner.nextLine();

        }
        if (counter <= 3) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
