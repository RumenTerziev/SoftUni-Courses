import java.io.*;

public class CalculatorApplication {
    public static void main(String[] args) throws IOException {


        int result = Calculator.calculate(10, 10, Operations.divide);

        System.out.println(result);
    }
}
