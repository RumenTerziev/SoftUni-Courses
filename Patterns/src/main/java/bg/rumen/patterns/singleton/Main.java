package bg.rumen.patterns.singleton;

import bg.rumen.patterns.singleton.threads.ThreadOne;
import bg.rumen.patterns.singleton.threads.ThreadThree;
import bg.rumen.patterns.singleton.threads.ThreadTwo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        start();

        DataSource resource = DataSource.getInstance();
        resource.getData().forEach(System.out::println);
        System.out.println(resource.getSize());


        int expectedSizeIfNoExceptions = 610;
        int actual = resource.getSize();
        System.out.println(expectedSizeIfNoExceptions == actual);

    }

    public static void start() throws InterruptedException {

        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadThree threadThree = new ThreadThree();
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();

        System.out.println("End");
    }
}
