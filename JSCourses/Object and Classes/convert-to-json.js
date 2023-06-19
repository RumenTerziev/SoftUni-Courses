function convertToJson(name, lastName, hairColor) {
    let person = {
        name,
        lastName,
        hairColor
    }

    let jsonObject = JSON.stringify(person);
    console.log(jsonObject);
}

convertToJson("George", "Jones", "Brown");