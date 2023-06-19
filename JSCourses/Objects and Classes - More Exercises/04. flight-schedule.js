function schedule(input) {

    let initialFlights = input[0];
    let newStatuses = input[1];
    let searchedStatus = input[2];

    let allFlights = {};

    for (const flight of initialFlights) {
        let currentLine = flight.split(' ');
        let flightCode = currentLine[0];
        let flightCity = currentLine[1];

        let flightObjecgt = {
            flightCode,
            flightCity,
            status: 'Ready to fly'
        }

        allFlights[flightCode] = flightObjecgt;
    }




    for (const cancelledFlight of newStatuses) {
        let lineCancelled  = cancelledFlight.split(' ');
        let cancelledCode = lineCancelled[0];
        
        if (allFlights.hasOwnProperty(cancelledCode)) {
            allFlights[cancelledCode].status = 'Cancelled';
        }

    }


    let allCancelled = Array.from(Object.values(allFlights)).filter((f) => f.status === 'Cancelled');
    let allReady = Array.from(Object.values(allFlights)).filter((f) => f.status === 'Ready to fly');

    if (searchedStatus[0] === 'Cancelled') {
        for (const currentCancelled of allCancelled) {
            console.log(`{ Destination: '${currentCancelled.flightCity}', Status: '${currentCancelled.status}' }`);
        }
    } else if (searchedStatus[0] === 'Ready to fly') {
        for (const currentReady of allReady) {
            console.log(`{ Destination: '${currentReady.flightCity}', Status: '${currentReady.status}' }`);
        }
    }

}

schedule([['WN269 Delaware',
'FL2269 Oregon',
'WN498 Las Vegas',
'WN3145 Ohio',
'WN612 Alabama',
'WN4010 New York',
'WN1173 California',
'DL2120 Texas',
'KL5744 Illinois',
'WN678 Pennsylvania'],
['DL2120 Cancelled',
'WN612 Cancelled',
'WN1173 Cancelled',
'SK430 Cancelled'],
['Cancelled']
]);