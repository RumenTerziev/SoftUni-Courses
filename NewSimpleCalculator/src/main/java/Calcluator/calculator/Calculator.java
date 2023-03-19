package Calcluator.calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class Calculator {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = getOperationsMap();



    public static int calculate(int firstNum, int secondNum, String operation) {

        if (getOperationsMap().containsKey(operation)) {
            return OPERATIONS.get(operation).apply(firstNum, secondNum);
        } else {
            throw new IllegalArgumentException("Invalid operation!");
        }

    }

    private static Map<String, BiFunction<Integer, Integer, Integer>> getOperationsMap() {

        Map<String, BiFunction<Integer, Integer, Integer>> resultMap = new HashMap<>();
        BiFunction<Integer, Integer, Integer> multiply = (f, s) -> f * s;
        BiFunction<Integer, Integer, Integer> divide = (f, s) -> f / s;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtract = (f, s) -> f - s;
        resultMap.put("multiply", multiply);
        resultMap.put("divide", divide);
        resultMap.put("add", add);
        resultMap.put("subtract", subtract);

        return Collections.unmodifiableMap(resultMap);
    }

}