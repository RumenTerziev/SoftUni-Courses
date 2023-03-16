package Calcluator.calculator;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CalculatorParamsDto {
    @NonNull
    private int firstNum;
    @NonNull
    private int secondNum;
    @NonNull
    private String operation;

}
