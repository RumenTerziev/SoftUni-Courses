function solve(number) {

 
    let numerString = number.toString();
  
    let sum = 0;
  
    for (let index = 0; index < numerString.length; index++) {
      
      let symbol = numerString.charAt(index);
      let digit = Number(symbol);
      sum += digit;
  
    }
  
    console.log(sum);
  
  }

  solve(222222);