package bg.rumen.threads;

import bg.rumen.Printer;

public class ThreadTwo extends Thread {

    Printer printer;

    public ThreadTwo(Printer printer) {
        this.printer = printer;
    }


    @Override
    public void run() {
        this.printer.trying();
    }


}
