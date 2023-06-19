function solve(...params) {
    
    let counter = 0;
    for (let index = 0; index < params.length; index++) {
        
        if (params[index] < 0) {
            counter++;
        }
        
    }

    if (counter % 2 == 0) {
        return 'Positive';
    } else {
        return 'Negative';
    }
}

console.log(solve(5, 12, -15));
