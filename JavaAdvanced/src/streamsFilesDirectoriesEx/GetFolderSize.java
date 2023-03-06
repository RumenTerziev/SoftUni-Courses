package streamsFilesDirectoriesEx;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("src/resourcesNew01/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumBytes = 0;

        while (!directories.isEmpty()) {

            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumBytes += file.length();
                }
             }

        }

        System.out.printf("Folder size: %d", sumBytes);
    }
}
