import java.util.Scanner;

public class Balls_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBalls = Integer.parseInt(scanner.nextLine());

        int points = 0;
        int redBallsCount = 0;
        int orangeBallsCount = 0;
        int yellowBallsCount = 0;
        int whiteBallsCount = 0;
        int blackBallsCount = 0;
        int otherColoursCount = 0;
        for (int n = 1; n <= countBalls; n++) {

            String colour = scanner.nextLine();

            switch (colour) {
                case "red":
                    redBallsCount++;
                    points = points + 5;
                    break;
                case "orange":
                    orangeBallsCount++;
                    points = points + 10;
                    break;
                case "yellow":
                    yellowBallsCount++;
                    points = points + 15;
                    break;
                case "white":
                    whiteBallsCount++;
                    points = points + 20;
                    break;
                case "black":
                    blackBallsCount++;
                    points = points / 2;
                    break;
                default:
                    otherColoursCount++;
                    break;
            }
        }
        System.out.printf("Total points: %d%n", points);
        System.out.printf("Red balls: %d%n", redBallsCount);
        System.out.printf("Orange balls: %d%n", orangeBallsCount);
        System.out.printf("Yellow balls: %d%n", yellowBallsCount);
        System.out.printf("White balls: %d%n", whiteBallsCount);
        System.out.printf("Other colors picked: %d%n", otherColoursCount);
        System.out.printf("Divides from black balls: %d%n", blackBallsCount);
    }
}
