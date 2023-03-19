package Calcluator.calculator;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CalculatorParamsDto {
    @NonNull
    private Integer firstNum;
    @NonNull
    private Integer secondNum;
    private String operation;
}
