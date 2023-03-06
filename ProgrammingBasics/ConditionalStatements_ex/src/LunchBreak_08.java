import java.util.Scanner;

public class LunchBreak_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int lasting = Integer.parseInt(scanner.nextLine());
        int lunchBreak = Integer.parseInt(scanner.nextLine());

        double lunchTime = lunchBreak / 8.0;
        double restTime = lunchBreak / 4.0;

        double freeTime = lunchBreak - lunchTime - restTime;
        double diff = Math.abs(freeTime - lasting);
        if (freeTime >= lasting) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movie, Math.ceil(diff));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movie, Math.ceil(diff));
        }

    }
}
