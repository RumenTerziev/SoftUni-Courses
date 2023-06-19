function solve(substring, text) {

    let wordLowerCase = substring.toLowerCase();

    let textArr = text.split(' ');

    for (const word of textArr) {
        if (word.toLowerCase() === wordLowerCase) {
            return substring;
        }
    }

    return `${substring} not found!`;

}

console.log(solve('javascript', 'JavaScript is the best programming language'));