import java.io.*;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();

        int result = calculator.calculate(10, 10, "divide");

        System.out.println(result);

    }
}
