function addressBook(inputArr) {

    let addresses = {};
    
    for (const line of inputArr) {
        let [name, address] = line.split(':');
        addresses[name] = address;    
    }
    
    Object.entries(addresses)
    .sort((first, second) => first[0].localeCompare(second[0]))
    .forEach(entry => console.log(`${entry[0]} -> ${entry[1]}`));

    // for (const entry of entries) {
    //     let [key, value] = entry;
    //     console.log(`${key} -> ${value}`);
    // }
}

addressBook(['Tim:Doe Crossing',

'Bill:Nelson Place',

'Peter:Carlyle Ave',

'Bill:Ornery Rd']);