function employeeFunction(input) {

    let asd = input.length;
    let employees = {};
    for (const string of input) {
        let employeeName = string;
        let personalNum = employeeName.length;

        employees[employeeName] = personalNum;
    }


    for (const key in employees) {

        console.log(`Name: ${key} -- Personal Number: ${employees[key]}`);

    }
}

employeeFunction([

    'Silas Butler',
    
    'Adnaan Buckley',
    
    'Juan Peterson',
    
    'Brendan Villarreal'
    
    ]);