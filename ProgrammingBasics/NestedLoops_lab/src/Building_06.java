import java.util.Scanner;

public class Building_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());


        String typeOfRoom = "";
        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (i == floors) {
                    typeOfRoom = "L";
                } else if (i % 2 == 0) {
                    typeOfRoom = "O";
                } else {
                    typeOfRoom = "A";
                }
                System.out.printf("%s%d%d ", typeOfRoom, i, j);
            }
            System.out.println();
        }

    }
}
