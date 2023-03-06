import java.util.Scanner;

public class TrainingLab_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double area = w * h;
        double deskW = 120;
        double deskH = 70;
        double desksPerRow = Math.floor((h * 100  - 100) / deskH);
        double rows = Math.floor((w * 100) / deskW);
        double numberOfDesks = desksPerRow * rows - 3;
        System.out.printf("%.0f",numberOfDesks);
    }
}
