package bg.softuni.bookshop.utils.io.log;

public class SysOutLogger implements Logger {

    @Override
    public void log(String outputMassage) {
        System.out.println(outputMassage);
    }

}
