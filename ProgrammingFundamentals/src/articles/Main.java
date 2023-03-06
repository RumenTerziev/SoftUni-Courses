package articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] newArticle = scanner.nextLine().split(", ");

        String title = newArticle[0];
        String content = newArticle[1];
        String author = newArticle[2];

        Article article = new Article(title, content, author);

        int countCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= countCommands; i++) {
            String[] commandLine = scanner.nextLine().split(": ");
            String commandType = commandLine[0];
            String newValue = commandLine[1];
            switch (commandType) {
                case "Edit":
                    article.edit(newValue);
                    break;

                case "ChangeAuthor":
                    article.changeAuthor(newValue);
                    break;

                case "Rename":
                    article.rename(newValue);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
