package TextProcessingMoreEx;

import java.util.Scanner;

public class Html {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        StringBuilder contentBuilder = new StringBuilder();


        System.out.println("<h1>".concat("\n").concat(title).concat("\n").concat("</h1>"));
        contentBuilder.append("<article>").append("\n").append(content).append("\n").append("</article>");
        System.out.println(contentBuilder);

        String command = scanner.nextLine();
        while (!command.equals("end of comments")) {
            String comment = command;
            System.out.println("<div>".concat("\n").concat(comment).concat("\n").concat("</div>"));

            command = scanner.nextLine();
        }
    }
}
