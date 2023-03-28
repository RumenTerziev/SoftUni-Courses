package Calcluator.calculator;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CalculatorParamsDto {
    @NonNull
    private Integer firstNum;
    @NonNull
    private Integer secondNum;
    @Pattern(regexp = "^add|subtract|multiply|divide$")
    private String operation;

}
