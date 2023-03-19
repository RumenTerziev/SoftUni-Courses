package Calcluator.controller;

import Calcluator.calculator.Calculator;
import Calcluator.calculator.CalculatorParamsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {
    
    @GetMapping
    @RequestMapping("/api/calculator")
    public String test(CalculatorParamsDto params) {
        try {

            int result = Calculator.calculate(params.getFirstNum(), params.getSecondNum(), params.getOperation());
            return result + "";
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

}
