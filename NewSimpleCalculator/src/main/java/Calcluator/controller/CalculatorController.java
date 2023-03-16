package Calcluator.controller;

import Calcluator.calculator.Calculator;
import Calcluator.calculator.CalculatorParamsDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    

    @GetMapping
    @RequestMapping("/api/calculator")
    public Integer test(@Validated CalculatorParamsDto params) {
        return Calculator.calculate(params.getFirstNum(), params.getSecondNum(), params.getOperation());
    }

}
