import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double allMoney = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double lightSabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int countLightSabers = 0;
        int countRobes = 0;
        int countBelts = 0;
        double totalLightSabersCost = 0;
        double totalRobesCost = 0;
        double totalBeltsCost = 0;
        for (int i = 1; i <= countStudents; i++) {
            countLightSabers++;
            countRobes++;
            countBelts++;

            totalLightSabersCost = totalLightSabersCost + lightSabersPrice;
            totalRobesCost = totalRobesCost + robesPrice;

            if (i % 6 == 0) {
                totalBeltsCost = totalBeltsCost + 0;
            } else {
                totalBeltsCost = totalBeltsCost + beltsPrice;
            }

        }
        totalLightSabersCost = (countStudents + Math.ceil(countStudents * 0.1)) * lightSabersPrice;

        double totalSum = totalLightSabersCost + totalRobesCost + totalBeltsCost;

        if (allMoney >= totalSum) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.%n", totalSum - allMoney);
        }
    }
}
