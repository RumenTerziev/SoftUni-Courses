import java.util.Scanner;

public class BarcodeGenerator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNum = Integer.parseInt(scanner.nextLine());
        int firstNumUnits = firstNum % 10;
        int firstNumTens = firstNum / 10 % 10;
        int firstNumHundreds = firstNum / 100 % 10;
        int firstNumThousands = firstNum / 1000;

        int secondNum = Integer.parseInt(scanner.nextLine());
        int secondNumUnits = secondNum % 10;
        int secondNumTens = secondNum / 10 % 10;
        int secondNumHundreds = secondNum / 100 % 10;
        int secondNumThousands = secondNum / 1000;

        for (int currentNum = firstNum; currentNum <= secondNum; currentNum++) {

            int currentNumUnits = currentNum % 10;
            int currentNumTens = currentNum / 10 % 10;
            int currentNumHundreds = currentNum / 100 % 10;
            int currentNumThousands = currentNum / 1000;

            boolean isValidUnits = currentNumUnits >= firstNumUnits && currentNumUnits <= secondNumUnits && currentNumUnits % 2 != 0;
            boolean isValidTens = currentNumTens >= firstNumTens && currentNumTens <= secondNumTens && currentNumTens % 2 != 0;
            boolean isValidHundreds = currentNumHundreds >= firstNumHundreds && currentNumHundreds <= secondNumHundreds && currentNumHundreds % 2 != 0;
            boolean isValidThousands = currentNumThousands >= firstNumThousands && currentNumThousands <= secondNumThousands && currentNumThousands % 2 != 0;


            if (isValidUnits && isValidTens && isValidHundreds && isValidThousands) {
                System.out.print(currentNum + " ");
            }


        }


    }
}
