import java.util.Scanner;

public class Moving_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int allPackages = width * length * height;

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            int currentPackages = Integer.parseInt(command);
            allPackages = allPackages - currentPackages;
            if (allPackages <= 0) {
                break;
            }

            command = scanner.nextLine();
        }
        if (allPackages < 0) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(allPackages));
        } else {
            System.out.printf("%d Cubic meters left.", allPackages);
        }
    }
}
