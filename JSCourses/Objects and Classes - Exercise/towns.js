function towns(input) {

    let townsArr = [];
    for (const tokens of input) {
        let [town, latitude, longitude] = tokens.split(' | ');

        let currentTown = {
            town,
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2)
        }

        townsArr.push(currentTown);
    }

    for (const current of townsArr) {
        console.log(current);
    }
}

towns(['Sofia | 42.696552 | 23.32601',

'Beijing | 39.913818 | 116.363625']);