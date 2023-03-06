import java.util.Scanner;

public class TrekkingMania_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());


        int musalaGroup = 0;
        int montblancGroup = 0;
        int kilimandjaroGroup = 0;
        int k2Group = 0;
        int everestGroup = 0;
        int totalClimbers = 0;
        double musalaPercent = 0;
        double montblancPercent = 0;
        double kilimandjaroPercent = 0;
        double k2Percent = 0;
        double everestPercent = 0;

        for (int n = 1; n <= groups; n++) {
            int groupMembers = Integer.parseInt(scanner.nextLine());
            if (groupMembers <= 5) {
                musalaGroup = musalaGroup + groupMembers;
            } else if (groupMembers <= 12) {
                montblancGroup = montblancGroup + groupMembers;
            } else if (groupMembers <= 25) {
                kilimandjaroGroup = kilimandjaroGroup + groupMembers;
            } else if (groupMembers <= 40) {
                k2Group = k2Group + groupMembers;
            } else {
                everestGroup = everestGroup + groupMembers;
            }
            totalClimbers = musalaGroup + montblancGroup + kilimandjaroGroup + k2Group + everestGroup;
        }
        musalaPercent = (musalaGroup * 1.0 / totalClimbers) * 100;
        montblancPercent = (montblancGroup * 1.0 / totalClimbers) * 100;
        kilimandjaroPercent = (kilimandjaroGroup * 1.0 / totalClimbers) * 100;
        k2Percent = (k2Group * 1.0 / totalClimbers) * 100;
        everestPercent = (everestGroup * 1.0 / totalClimbers) * 100;
        System.out.printf("%.2f%%%n", musalaPercent);
        System.out.printf("%.2f%%%n", montblancPercent);
        System.out.printf("%.2f%%%n", kilimandjaroPercent);
        System.out.printf("%.2f%%%n", k2Percent);
        System.out.printf("%.2f%%%n", everestPercent);
    }
}
