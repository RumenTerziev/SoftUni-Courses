function tracker(input) {

    let searchedWords = input.shift().split(' ');
    let occurrences = {};
    for (const word of searchedWords) {
        let count = input.filter((w) => w === word).length;
        occurrences[word] = count;
    }


    let wordsArray = Object.entries(occurrences)
        .sort((firstWord, secondWord) => {
        let [_wordOne, valueOne] = firstWord;
        let [_wordTwo, valueTwo] = secondWord;

        return valueTwo - valueOne;
    });

for (const entry of wordsArray) {

    let [key, value] = entry;
    console.log(`${key} - ${value}`);
}
  

}

tracker([

    'this sentence',
    
    'In', 'this', 'sentence', 'you', 'have',
    
    'to', 'count', 'the', 'occurrences', 'of',
    
    'the', 'words', 'this', 'and', 'sentence',
    
    'because', 'this', 'is', 'your', 'task'
    
    ]);