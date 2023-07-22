package bg.rumen.patterns.singleton.threads;

import bg.rumen.patterns.singleton.DataSource;

public class ThreadThree extends Thread {



    @Override
    public void run() {
        DataSource resource = DataSource.getInstance();

        resource.getData().forEach(System.out::println);
        resource.getSize();

        for (int i = 0; i < 20; i++) {

            resource.addData("Pretty");
            resource.addData("Cool");
            resource.addData("Text");

            resource.addData("Why");
            resource.addData("am");
            resource.addData("I");
            resource.addData("Doing");
            resource.addData("This");

            resource.addData("Message");
            resource.addData("Here");
        }

        resource.getData().forEach(System.out::println);
        resource.getSize();

    }

}
