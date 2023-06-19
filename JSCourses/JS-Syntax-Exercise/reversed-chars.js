function solve(charOne, charTwo, charThree) {


    let outputArr = [];
  
    outputArr.push(charOne);
    outputArr.push(charTwo);
    outputArr.push(charThree);
  
    outputArr.reverse();
  
    console.log(outputArr.join(' '));
   
  }

  solve('A', 'B', 'C');