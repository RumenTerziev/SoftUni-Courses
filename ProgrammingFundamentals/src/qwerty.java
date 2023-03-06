
import java.util.Scanner;

public class qwerty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println(a);
        System.out.println(b);
    }
}
