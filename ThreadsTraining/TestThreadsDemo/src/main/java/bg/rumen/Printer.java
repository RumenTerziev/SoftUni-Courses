package bg.rumen;

public class Printer {


    public synchronized void printStrings() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!");
    }

    public void trying() {
        System.out.println("Trying...");

        synchronized(this) {
            System.out.println("Did it!");
        }
    }



}
