import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;


public class CalculatorApplicationTest {

    private Calculator calculator;


    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void testCalculateShouldAddCorrectly() throws IOException {

        int expected = 10;
        int actual = calculator.calculate(5, 5, Operations.add);

        assertEquals(expected, actual);

    }

    @Test
    public void testCalculateShouldSubtractCorrectly() throws IOException {
        int expected = 5;
        int actual = calculator.calculate(10, 5, Operations.subtract);

        assertEquals(expected, actual);

    }


    @Test
    public void testCalculateShouldMultiplyCorrectly() throws IOException {
        int expected = 50;
        int actual = calculator.calculate(10, 5, Operations.multiply);

        assertEquals(expected, actual);

    }


    @Test
    public void testCalculateShouldDivideCorrectly() throws IOException {
        int expected = 2;
        int actual = calculator.calculate(10, 5, Operations.divide);

        assertEquals(expected, actual);

    }


}
