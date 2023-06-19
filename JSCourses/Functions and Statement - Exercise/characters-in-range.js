function solve(charOne, charTwo) {
  let charArr = [];

  let firstNum = charOne.charCodeAt(0);
  let secondNum = charTwo.charCodeAt(0);

  let start;
  let end;
  if (firstNum > secondNum) {
    start = secondNum;
    end = firstNum;
  } else {
    start = firstNum;
    end = secondNum;
  }
    
  for (let index = start + 1; index < end; index++) {
    let char = String.fromCharCode(index);
    charArr.push(char);
  }

  console.log(charArr.join(' '));
}

solve('C', '#');
