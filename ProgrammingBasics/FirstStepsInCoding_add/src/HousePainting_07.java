import java.util.Scanner;

public class HousePainting_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double windowArea = 1.5 * 1.5;
        double doorArea = 1.2 * 2;
        double sideWallArea = x * y;
        double frontWallArea = x * x;
        double roofRectangleArea = x * y;
        double roofTriangleArea = x * h / 2;
        double downPartHouseArea = (2 * sideWallArea) - (2 * windowArea) + (2 * frontWallArea) - doorArea;
        double roofArea = 2 * roofRectangleArea + 2 * roofTriangleArea;
        double greenPaint = downPartHouseArea / 3.4;
        double redPaint = roofArea / 4.3;
        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
