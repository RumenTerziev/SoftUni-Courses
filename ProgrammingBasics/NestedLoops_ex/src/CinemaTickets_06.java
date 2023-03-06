import java.util.Scanner;

public class CinemaTickets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countStudentTickets = 0;
        int countStandardTickets = 0;
        int countKidsTickets = 0;
        int countAllTickets = 0;
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String movie = command;
            int seats = Integer.parseInt(scanner.nextLine());


            int countCurrentTickets = 0;

            String typeOfTicket = scanner.nextLine();
            while (!typeOfTicket.equals("End")) {
                countCurrentTickets++;
                countAllTickets++;
                switch (typeOfTicket) {
                    case "student":
                        countStudentTickets++;
                        break;
                    case "standard":
                        countStandardTickets++;
                        break;
                    case "kid":
                        countKidsTickets++;
                        break;
                }


                if (countCurrentTickets >= seats) {
                    break;
                }
                typeOfTicket = scanner.nextLine();
            }


            System.out.printf("%s - %.2f%% full.%n", movie, countCurrentTickets / (seats * 1.0) * 100);
            command = scanner.nextLine();
        }


        System.out.printf("Total tickets: %d%n", countAllTickets);
        System.out.printf("%.2f%% student tickets.%n", countStudentTickets / (countAllTickets * 1.0) * 100);
        System.out.printf("%.2f%% standard tickets.%n", countStandardTickets / (countAllTickets * 1.0) * 100);
        System.out.printf("%.2f%% kids tickets.%n", countKidsTickets / (countAllTickets * 1.0) * 100);
    }
}
