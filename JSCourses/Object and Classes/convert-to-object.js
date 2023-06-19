function jsonParser(jsonObject) {

    let person = JSON.parse(jsonObject);

    for (const key in person) {
        console.log(`${key}: ${person[key]}`);
    }

}

jsonParser('{"name": "George", "age": 40, "town": "Sofia"}');