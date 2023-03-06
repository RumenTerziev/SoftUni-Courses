import java.util.Scanner;

public class BarCode_0602 {
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


            for (int j = firstNumThousands; j <= secondNumThousands ; j++) {
                for (int k = firstNumHundreds; k <= secondNumHundreds ; k++) {
                    for (int l = firstNumTens; l <= secondNumTens ; l++) {
                        for (int m = firstNumUnits; m <= secondNumUnits; m++) {
                            if (j % 2 != 0 && k % 2 != 0 && l % 2 != 0 && m % 2 != 0) {
                                System.out.printf("%d%d%d%d ",j,k,l,m);
                            }
                        }
                    }
                }
            }

    }
}
