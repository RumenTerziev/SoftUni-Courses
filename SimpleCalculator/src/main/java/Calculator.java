import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private Integer result;

    public Calculator() {
    }


    public int calculate(int firstNum, int secondNum, String operation) throws IOException {


        BiFunction<Integer, Integer, Integer> multiply = (f, s) -> f * s;
        BiFunction<Integer, Integer, Integer> divide = (f, s) -> f / s;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtract = (f, s) -> f - s;


        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

        operations.put("multiply", multiply);
        operations.put("divide", divide);
        operations.put("add", add);
        operations.put("subtract", subtract);

        operations.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(operation))
                .forEach(entry -> result = entry.getValue().apply(firstNum, secondNum));

        return result;
    }




}
