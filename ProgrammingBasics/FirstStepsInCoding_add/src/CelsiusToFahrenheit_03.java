import java.util.Scanner;

public class CelsiusToFahrenheit_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        T (° F) = T (° C) × 1,8 + 32

        double tCelsius = Double.parseDouble(scanner.nextLine());
        double tFahrenheit = tCelsius * 1.8 + 32;
        System.out.printf("%.2f",tFahrenheit);

    }
}
