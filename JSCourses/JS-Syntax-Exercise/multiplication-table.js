function solve(number) {

    let result;

    for (let multiplier = 1; multiplier <= 10; multiplier++) {
        
        result = number * multiplier;
        console.log(`${number} X ${multiplier} = ${result}`);

    }


}

solve(5);