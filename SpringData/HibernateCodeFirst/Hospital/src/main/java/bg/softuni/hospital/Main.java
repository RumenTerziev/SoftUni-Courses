package bg.softuni.hospital;

import bg.softuni.hospital.engine.Runner;

public class Main {

    public static void main(String[] args) {

        try {
            Runner.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
