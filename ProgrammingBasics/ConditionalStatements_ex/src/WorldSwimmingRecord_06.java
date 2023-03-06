import java.util.Scanner;

public class WorldSwimmingRecord_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double worldRecord = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double secsPerMeter = Double.parseDouble(scanner.nextLine());
        double resistance = Math.floor((meters / 15)) * 12.5;
        double totalTime = meters * secsPerMeter + resistance;
        double diff = Math.abs(totalTime - worldRecord);
        if (totalTime < worldRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        }
    }
}
