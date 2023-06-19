function shopping(input) {

    let firstLine = input.shift();

    let groceries = firstLine.split('!');

    for (const line of input) {

        let commandLine = line.split(' ');
        let command = commandLine[0];
        let item = commandLine[1];

        if (command === 'Urgent') {
            if (!groceries.includes(item)) {
                groceries.unshift(item);
            }

        } else if (command === 'Unnecessary') { 
      
            if (groceries.includes(item)) {
                let index = groceries.indexOf(item);
                groceries.splice(index, 1);
            }

        } else if (command === 'Correct') {

            let oldItem = commandLine[1];
            let newItem = commandLine[2];
            
            if (groceries.includes(oldItem)) {
                let index = groceries.indexOf(oldItem);
                groceries.splice(index, 1, newItem);
            }

        } else if (command === 'Rearrange') {
            if (groceries.includes(item)) {
                let index = groceries.indexOf(item);
                let removed = groceries.splice(index, 1);
                groceries.push(removed);
            }
        } else if(command === 'Go') {
            break;
        }


    }

    console.log(groceries.join(', '));


}

shopping(["Milk!Pepper!Salt!Water!Banana",

"Urgent Salt",

"Unnecessary Grapes",

"Correct Pepper Onion",

"Rearrange Grapes",

"Correct Tomatoes Potatoes",

"Go Shopping!"]);