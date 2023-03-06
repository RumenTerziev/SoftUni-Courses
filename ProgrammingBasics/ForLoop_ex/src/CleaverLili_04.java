import java.util.Scanner;

public class CleaverLili_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double oddAge = 0;
        double evenAge = 0;
        double money = 0;
        double allMoney = 0;
        double toysCount = 0;
        double brotherMoney = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                money = money + 10;
                allMoney = allMoney + money;
                brotherMoney++;
            } else {
                toysCount++;
            }
        }
        double sumToys = toysCount * toyPrice;
        double totalSum = sumToys + allMoney - brotherMoney;
        double diff = Math.abs(totalSum - washingMachinePrice);

        if (totalSum >= washingMachinePrice) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }

    }
}
