function factorialDivision(numberOne, numberTwo) {

  let factOne = factorial(numberOne);

  let factTwo = factorial(numberTwo);

  let division = factOne / factTwo;

  console.log(division.toFixed(2));


  function factorial(number) {
    if (number > 0) {
        return number * factorial(number - 1);
    } else {
        return 1;
    }
  }

}

factorialDivision(6, 2);
