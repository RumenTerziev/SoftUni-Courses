function piccolo(input) {

    let cars = [];
    for (const line of input) {
        let tokens = line.split(', ');
        let command = tokens[0];
        let number = tokens[1];

        if (command === 'IN') {
            if (!cars.includes(number)) {
                cars.push(number);
            }
        } else if(command === 'OUT') {
           let index = cars.indexOf(number);
           if (index != -1) {
            cars.splice(index, 1);
           }
        }
    }


    if (cars.length === 0) {
    
        console.log('Parking Lot is Empty');
        
    } else {
        cars.sort((f, s) => f.localeCompare(s)).forEach(e => console.log(e));
    }

}


piccolo(['IN, CA2844AA', 'IN, CA1234TA', 'OUT, CA2844AA', 'IN, CA9999TT', 'IN, CA2866HI', 'OUT, CA1234TA', 'IN, CA2844AA', 'OUT, CA2866HI', 'IN, CA9876HH', 'IN, CA2822UU']);

// piccolo(['IN, CA2844AA',
// 'IN, CA1234TA',
// 'OUT, CA2844AA',
// 'OUT, CA1234TA']);