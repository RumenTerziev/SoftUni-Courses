function solve(firstNum, secondNum, operation) {

    const multiply = (a, b) => a * b;
    const divide = (a, b) => a / b;
    const add = (a, b) => a + b;
    const subtract = (a, b) => a - b;

  
    const operationMap = {
        multiply,
        divide,
        add,
        subtract
    };

    return operationMap[operation](firstNum, secondNum);
 
}

console.log(solve(5, 5, 'multiply'));
