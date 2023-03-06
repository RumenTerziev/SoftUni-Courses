package methods_lab;

import java.util.Scanner;

public class signOfIntegerNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        signOfInteger(number);
    }

    public static void signOfInteger(int n) {

        if (n == 0) {
            System.out.printf("The number %d is zero.", n);
        } else if (n > 0) {
            System.out.printf("The number %d is positive.", n);
        } else {
            System.out.printf("The number %d is negative.", n);
        }
    }
}
