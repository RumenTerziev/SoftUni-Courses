function solve(number) {

 
    let numerString = number.toString();
  
    let isValid = true;
    let symbol = numerString.charAt(0);
    let digitToCompare = Number(symbol);
  
    let sum = 0;
  
    for (let index = 0; index < numerString.length; index++) {
      
      let symbol = numerString.charAt(index);
      let digit = Number(symbol);
      sum += digit;
  
      if (digitToCompare !== digit) {
        isValid = false;
      }
  
    }
  
    console.log(isValid);
    console.log(sum);
  
  }
  
  solve (1234);