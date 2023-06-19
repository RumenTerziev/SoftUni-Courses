function pianist(input) {

    let numberOfPieces = input.shift();
    let piecesArr =  input.splice(0, numberOfPieces);
    let pieces = {};


  for (let index = 0; index < piecesArr.length; index++) {
    const line = piecesArr[index];
    let [piece, composer, key] = line.split('|');
    pieces[piece] = {composer, key};
  }


  for (const line of input) {
    let commandLine = line.split('|');
    let command = commandLine[0];
    let piece = commandLine[1];

    if (command === 'Add') {
        if (!pieces.hasOwnProperty(piece)) {
            let composer = commandLine[2];
            let key = commandLine[3];
            pieces[piece] = {composer, key};
            console.log(`${piece} by ${composer} in ${key} added to the collection!`);
        } else {
            console.log(`${piece} is already in the collection!`);
        }

    } else if (command === 'Remove') {
        if (pieces.hasOwnProperty(piece)) {
           delete pieces[piece];
            console.log(`Successfully removed ${piece}!`);
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    } else if (command === 'ChangeKey') {
        let searchedPiece = commandLine[1];
        if (pieces.hasOwnProperty(searchedPiece)) {
            let newKey = commandLine[2];
            pieces[piece].key = newKey;
            console.log(`Changed the key of ${piece} to ${newKey}!`);
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    } else if (command === 'Stop') {
        break;
    }
  }

  for (const key in pieces) {
        const element = pieces[key];
       console.log(`${key} -> Composer: ${element.composer}, Key: ${element.key}`);
  }

}

pianist([
    '4',
    'Eine kleine Nachtmusik|Mozart|G Major',
    'La Campanella|Liszt|G# Minor',
    'The Marriage of Figaro|Mozart|G Major',
    'Hungarian Dance No.5|Brahms|G Minor',
    'Add|Spring|Vivaldi|E Major',
    'Remove|The Marriage of Figaro',
    'Remove|Turkish March',
    'ChangeKey|Spring|C Major',
    'Add|Nocturne|Chopin|C# Minor',
    'Stop'
  ]);