import java.util.Scanner;

public class messages_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < number; i++) {
            String stringNum = scanner.nextLine();
            char currentSymbol = '@';
            if (stringNum.length() == 1) {
                switch (stringNum) {
                    case "2":
                        currentSymbol = 'a';
                        break;
                    case "3":
                        currentSymbol = 'd';
                        break;
                    case "4":
                        currentSymbol = 'g';
                        break;
                    case "5":
                        currentSymbol = 'j';
                        break;
                    case "6":
                        currentSymbol = 'm';
                        break;
                    case "7":
                        currentSymbol = 'p';
                        break;
                    case "8":
                        currentSymbol = 't';
                        break;
                    case "9":
                        currentSymbol = 'w';
                        break;
                    case "0":
                        currentSymbol = ' ';
                        break;
                }

            } else if (stringNum.length() == 2) {
                switch (stringNum) {
                    case "22":
                        currentSymbol = 'b';
                        break;
                    case "33":
                        currentSymbol = 'e';
                        break;
                    case "44":
                        currentSymbol = 'h';
                        break;
                    case "55":
                        currentSymbol = 'k';
                        break;
                    case "66":
                        currentSymbol = 'n';
                        break;
                    case "77":
                        currentSymbol = 'q';
                        break;
                    case "88":
                        currentSymbol = 'u';
                        break;
                    case "99":
                        currentSymbol = 'x';
                        break;

                }
            } else if (stringNum.length() == 3) {
                switch (stringNum) {
                    case "222":
                        currentSymbol = 'c';
                        break;
                    case "333":
                        currentSymbol = 'f';
                        break;
                    case "444":
                        currentSymbol = 'i';
                        break;
                    case "555":
                        currentSymbol = 'l';
                        break;
                    case "666":
                        currentSymbol = 'o';
                        break;
                    case "777":
                        currentSymbol = 'r';
                        break;
                    case "888":
                        currentSymbol = 'v';
                        break;
                    case "999":
                        currentSymbol = 'y';
                        break;

                }

            } else if (stringNum.length() == 4) {
                switch (stringNum) {
                    case "7777":
                        currentSymbol = 's';
                        break;
                    case "9999":
                        currentSymbol = 'z';
                        break;


                }

            }
            if (currentSymbol != '@') {
                System.out.print(currentSymbol);
            }
        }

    }
}
