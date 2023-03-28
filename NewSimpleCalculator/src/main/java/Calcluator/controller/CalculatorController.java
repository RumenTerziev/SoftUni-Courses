package Calcluator.controller;


import Calcluator.calculator.Calculator;
import Calcluator.calculator.CalculatorParamsDto;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
public class CalculatorController {
    @GetMapping
    @RequestMapping("/api/calculator")
    public String test(@Valid CalculatorParamsDto params) {

        return Calculator.calculate(params.getFirstNum(), params.getSecondNum(), params.getOperation()) + "";
    }
}
