import java.util.Scanner;

public class Firm_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int employees = Integer.parseInt(scanner.nextLine());

        double daysOfProject = days - days * 0.10;
        double hoursOfProject = daysOfProject * 8;
        double overtime = employees * (2 * days);
        double totalHours = Math.floor(hoursOfProject + overtime);

        double diff = Math.abs(hoursNeeded - totalHours);

        if (totalHours >= hoursNeeded) {
            System.out.printf("Yes!%.0f hours left.", diff);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", diff);
        }

    }
}
