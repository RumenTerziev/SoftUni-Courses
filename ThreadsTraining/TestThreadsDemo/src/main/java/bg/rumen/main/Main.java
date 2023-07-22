package bg.rumen.main;

import bg.rumen.Printer;
import bg.rumen.threads.ThreadOne;
import bg.rumen.threads.ThreadTwo;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        ThreadOne threadOne = new ThreadOne(printer);
        ThreadTwo threadTwo = new ThreadTwo(printer);

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
