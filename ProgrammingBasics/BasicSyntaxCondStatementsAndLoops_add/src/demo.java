import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                int n = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < n; i++) {
                    String input = scanner.nextLine();
                    char currentSymbol = '@';
                    switch (input) {
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
                            currentSymbol = 'u';
                            break;
                        case "999":
                            currentSymbol = 'y';
                            break;
                        case "7777":
                            currentSymbol = 's';
                            break;
                        case "9999":
                            currentSymbol = 'z';
                            break;
                        default:
                            continue;
                    }
                        System.out.print(currentSymbol);


            }


    }
}
