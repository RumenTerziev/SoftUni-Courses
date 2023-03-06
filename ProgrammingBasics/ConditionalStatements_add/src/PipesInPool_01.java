import java.util.Scanner;

public class PipesInPool_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double firstPipe = p1 * h;
        double secondPipe = p2 * h;
        double totalLiters = firstPipe + secondPipe;
        double difference = Math.abs(totalLiters - v);
        double filledPercents = (totalLiters / v) * 100;
        double firstPipePercents = (firstPipe / totalLiters) * 100;
        double secondPipePercents = (secondPipe / totalLiters) * 100;

        double diff = Math.abs(totalLiters - v);

        if (totalLiters <= v) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", filledPercents, firstPipePercents, secondPipePercents);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, difference);
        }

    }
}
