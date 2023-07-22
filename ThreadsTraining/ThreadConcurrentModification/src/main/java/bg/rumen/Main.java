package bg.rumen;

import bg.rumen.threads.ThreadOne;
import bg.rumen.threads.ThreadThree;
import bg.rumen.threads.ThreadTwo;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        start();

        Resource resource = Resource.getInstance();
        resource.getStrings().forEach(System.out::println);
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
