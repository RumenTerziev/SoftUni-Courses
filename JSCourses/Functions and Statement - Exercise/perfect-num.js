function solve(number) {

    let isPositive = number >= 0;
    let output = '';

    
    let sumDivisors = 0;
    for (let currentNum = 0; currentNum < number; currentNum++) {
        
        if (number % currentNum === 0) {
            sumDivisors += currentNum;
        }
    }

    if (number === sumDivisors && isPositive) {
        output = "We have a perfect number!";
    } else {
        output = "It's not so perfect.";
    }

    return output;
}


console.log(solve(28));