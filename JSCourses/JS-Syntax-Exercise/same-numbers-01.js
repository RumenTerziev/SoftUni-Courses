function solve(number) {


    let isValid = true;
    let digitToCompare = number % 10;
    let sum = 0;
    while (number > 0) {
  
  
        let lastDigit = number % 10;
        sum += lastDigit;
        
        if (digitToCompare !== lastDigit) {
          isValid = false;
        }
  
        number = Math.trunc(number / 10);
    }
  
  
    console.log(isValid);
    console.log(sum);
   
  }

  solve(2222222);