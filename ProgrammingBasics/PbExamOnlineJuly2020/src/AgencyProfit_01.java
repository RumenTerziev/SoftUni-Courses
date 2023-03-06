import java.util.Scanner;

public class AgencyProfit_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();
        int adultsTickets = Integer.parseInt(scanner.nextLine());
        int kidsTickets = Integer.parseInt(scanner.nextLine());
        double adultsTicketsPrice = Double.parseDouble(scanner.nextLine());
        double serviceFee = Double.parseDouble(scanner.nextLine());

        double kidsTicketsPrice = (adultsTicketsPrice - (adultsTicketsPrice * 0.7));
        double totalIncomes = adultsTickets * (adultsTicketsPrice + serviceFee) +
                kidsTickets * (kidsTicketsPrice + serviceFee);
        double companyProfit = totalIncomes * 0.2;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, companyProfit);
    }
}
