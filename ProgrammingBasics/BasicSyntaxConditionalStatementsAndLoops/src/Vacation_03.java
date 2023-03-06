import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTickets = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();


        double ticketPrice = 0;
        double totalPrice = 0;
        if (typeOfGroup.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                ticketPrice = 8.45;
            } else if (dayOfWeek.equals("Saturday")) {
                ticketPrice = 9.80;
            } else if (dayOfWeek.equals("Sunday")) {
                ticketPrice = 10.46;
            }

        } else if (typeOfGroup.equals("Business")) {
            if (dayOfWeek.equals("Friday")) {
                ticketPrice = 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                ticketPrice = 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                ticketPrice = 16;
            }

        } else if (typeOfGroup.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                ticketPrice = 15;
            } else if (dayOfWeek.equals("Saturday")) {
                ticketPrice = 20;
            } else if (dayOfWeek.equals("Sunday")) {
                ticketPrice = 22.50;
            }
        }
        totalPrice = countTickets * ticketPrice;

        if (typeOfGroup.equals("Students") && countTickets >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (typeOfGroup.equals("Business") && countTickets >= 100) {
            totalPrice = totalPrice - (ticketPrice * 10);
        } else if (typeOfGroup.equals("Regular") && countTickets >= 10 && countTickets <= 20) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
