import java.util.Scanner;

public class Hospital_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int totalTreatedPatients = 0;
        int totalUntreatedPatients = 0;
        for (int i = 1; i <= period; i++) {
            int patientsForTheDay = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0 && totalUntreatedPatients > totalTreatedPatients) {
                doctors++;
            }
            if (patientsForTheDay >= doctors) {
                treatedPatients = doctors;
            } else {
                treatedPatients = patientsForTheDay;
            }
            untreatedPatients = patientsForTheDay - treatedPatients;

            totalTreatedPatients = totalTreatedPatients + treatedPatients;
            totalUntreatedPatients = totalUntreatedPatients + untreatedPatients;
        }

        System.out.printf("Treated patients: %d.%n", totalTreatedPatients);
        System.out.printf("Untreated patients: %d.", totalUntreatedPatients);
    }
}