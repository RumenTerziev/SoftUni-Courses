package textProcessingEx;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] filePath = scanner.nextLine().split("\\\\");

        String file = "";
        String fileExtension = "";
        for (int i = 0; i <= filePath.length - 1; i++) {
            String currentFileName = filePath[i];

            if (currentFileName.contains(".")) {
                file = currentFileName.split("\\.")[0];
                fileExtension = currentFileName.split("\\.")[1];

            }
        }
        System.out.printf("File name: %s%n", file);
        System.out.printf("File extension: %s", fileExtension);
    }
}
