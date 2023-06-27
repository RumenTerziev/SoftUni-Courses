package utils;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Reader {
    private final InputStreamReader inputStreamReader;

    public Reader(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }


    public String readLine() {
        Scanner scanner = new Scanner(this.inputStreamReader);
        return scanner.nextLine();
    }
}
