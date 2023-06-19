function solve(firstNum, secondNum) {
  
    let sum = 0;
    let numbers = [];
    for (let number = firstNum; number <= secondNum; number++) {
        numbers.push(number);
        sum += number;
    }

    console.log(numbers.join(' '));
    console.log(`Sum: ${sum}`);
  }

  solve(5, 10);