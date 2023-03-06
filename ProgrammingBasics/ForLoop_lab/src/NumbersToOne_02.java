import java.util.Scanner;

public class NumbersToOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int num = n; num >= 1; num--) {
            System.out.println(num);
        }
    }
}
