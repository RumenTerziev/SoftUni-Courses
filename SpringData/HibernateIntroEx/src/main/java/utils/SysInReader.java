package utils;

import utils.interfaces.Reader;

import java.util.Scanner;

public class SysInReader implements Reader {

    private static final Scanner SCANNER  = new Scanner(System.in);

    @Override
    public String readLine() {
        return SCANNER.nextLine();
    }
}
