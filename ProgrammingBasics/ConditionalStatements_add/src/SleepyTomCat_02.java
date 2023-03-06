import java.util.Scanner;

public class SleepyTomCat_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int freeDays = Integer.parseInt(scanner.nextLine());

        int minutesPerYear = 30000;
        int minutesPerDay = 0;
        int daysOnWork = 365 - freeDays;

        double totalGameTime = (freeDays * 127) + (daysOnWork * 63);
        double diff = Math.abs(totalGameTime - minutesPerYear);
        double hours = diff / 60;
        double minutes = diff % 60;
        if (totalGameTime <= minutesPerYear) {
            System.out.printf("Tom sleeps well\n" +
                    "%.0f hours and %.0f minutes less for play", Math.floor(hours), minutes);
        } else {
            System.out.printf("Tom will run away\n" +
                    "%.0f hours and %.0f minutes more for play", Math.floor(hours), minutes);
        }
    }
}
