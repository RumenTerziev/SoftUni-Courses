import java.io.*;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();

        int result = calculator.calculate(5, 10, "add");

        System.out.println(result);


    }
}
