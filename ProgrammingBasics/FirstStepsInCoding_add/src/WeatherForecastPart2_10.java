import java.util.Scanner;

public class WeatherForecastPart2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double degrees = Double.parseDouble(scanner.nextLine());

        if (degrees < 5) {
            System.out.println("unknown");
        } else if (degrees < 12) {
            System.out.println("Cold");
        } else if (degrees < 15) {
            System.out.println("Cool");
        } else if (degrees < 20.1) {
            System.out.println("Mild");
        } else if (degrees < 26) {
            System.out.println("Warm");
        } else if (degrees <= 35) {
            System.out.println("Hot");
        } else {
            System.out.println("unknown");
        }
    }
}
