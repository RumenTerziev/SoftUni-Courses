function solve(firstNum, secondNum, thirdNum) {
  return sum(firstNum, secondNum) - thirdNum;

  function sum(first, second) {
    return first + second;
  }
}

console.log(solve(23, 6, 10));
