function solve(array, number) {

    if (number >= array.length) {
        number = number % array.length;
    }

    for (let index = 0; index < number; index++) {

        let removed = array.shift();
        array.push(removed);        
    }
    console.log(array.join(' '));
}

solve ([51, 47, 32, 61], 5);