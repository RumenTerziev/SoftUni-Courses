import java.util.Scanner;

public class SpaceShip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double astronautHeight = Double.parseDouble(scanner.nextLine());


        double spaceCraftVolume = width * length * height;
        double roomVolume = (astronautHeight + 0.40) * 2 * 2;
        double totalRooms = Math.floor(spaceCraftVolume / roomVolume);

        if (totalRooms < 3) {
            System.out.println("The spacecraft is too small.");
        } else if (totalRooms >= 3 && totalRooms <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", totalRooms);
        } else {
            System.out.println("The spacecraft is too big.");
        }
    }
}
