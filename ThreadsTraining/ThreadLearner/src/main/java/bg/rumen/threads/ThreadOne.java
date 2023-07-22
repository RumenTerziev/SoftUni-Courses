package bg.rumen.threads;

public class ThreadOne extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s%n", this.getName());
        }
    }

}