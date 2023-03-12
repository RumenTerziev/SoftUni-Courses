import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class Calculator {
    private static final Map<Operations, BiFunction<Integer, Integer, Integer>> OPERATIONS = getOperationsMap();



    public static int calculate(int firstNum, int secondNum, Operations operation) {

            return OPERATIONS.get(operation).apply(firstNum, secondNum);

    }

    private static Map<Operations, BiFunction<Integer, Integer, Integer>> getOperationsMap() {

        Map<Operations, BiFunction<Integer, Integer, Integer>> resultMap = new HashMap<>();
        BiFunction<Integer, Integer, Integer> multiply = (f, s) -> f * s;
        BiFunction<Integer, Integer, Integer> divide = (f, s) -> f / s;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtract = (f, s) -> f - s;
        resultMap.put(Operations.multiply, multiply);
        resultMap.put(Operations.divide, divide);
        resultMap.put(Operations.add, add);
        resultMap.put(Operations.subtract, subtract);

        return Collections.unmodifiableMap(resultMap);
    }


}
