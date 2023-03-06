import java.util.Scanner;

public class AreaOfFigures_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
            double area = 0;
        if (figure.equals("square")) {
            double lengthSquare = Double.parseDouble(scanner.nextLine());
            area = lengthSquare * lengthSquare;
        } else if (figure.equals("rectangle")) {
            double lengthRectangle = Double.parseDouble(scanner.nextLine());
            double widthRectangle = Double.parseDouble(scanner.nextLine());
            area = lengthRectangle * widthRectangle;
        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * (Math.pow(radius, 2));
        } else if (figure.equals("triangle")) {
            double lengthTriangle = Double.parseDouble(scanner.nextLine());
            double heightTriangle = Double.parseDouble(scanner.nextLine());
            area = lengthTriangle * heightTriangle / 2;
        }System.out.printf("%.3f",area);
    }
}
