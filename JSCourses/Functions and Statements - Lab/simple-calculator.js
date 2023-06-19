function solve(numberOne, numberTwo, operation) {
  let result;
  switch (operation) {
    case "multiply":
      result = numberOne * numberTwo;
      break;
    case "divide":
      result = numberOne / numberTwo;
      break;
    case "add":
      result = numberOne + numberTwo;
      break;
    case "subtract":
      result = numberOne - numberTwo;
      break;
  }

  console.log(result);
}

solve(5, 5, "multiply");
