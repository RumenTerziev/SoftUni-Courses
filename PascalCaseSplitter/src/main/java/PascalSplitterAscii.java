import java.util.Scanner;

public class PascalSplitterAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder output = new StringBuilder();
        for (int index = 0; index < text.length(); index++) {

            char currentSymbol = text.charAt(index);

            if (currentSymbol >= 65 && currentSymbol <= 90) {

                if (output.length() > 0) {
                    output.append(", ");
                }

                output.append(currentSymbol);

            } else {
                output.append(currentSymbol);
            }
        }

        System.out.println(output);
    }
}
