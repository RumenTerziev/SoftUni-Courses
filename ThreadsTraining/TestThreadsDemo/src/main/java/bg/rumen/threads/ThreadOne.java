package bg.rumen.threads;

import bg.rumen.Printer;

public class ThreadOne extends Thread {

    Printer printer;

    public ThreadOne(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        this.printer.printStrings();
    }
}
