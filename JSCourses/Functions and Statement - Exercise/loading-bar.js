function loadingBar(number) {

    let notComplete = number < 100;

    let charArray = [];

    let countCharacters = number;
    while (countCharacters > 0) {

        charArray.push('%');
        countCharacters -= 10;
    }

    let output = '';
    if (notComplete) {
        charArray.push('.'.repeat(10 - Math.trunc(number / 10)));
        output = `${number}% [${charArray.join('')}]\n`;
        output += 'Still loading...';
    } else {
        output = '100% Colmplete!\n';
        output += `[${charArray.join('')}]`;
    }

    console.log(output);
}

loadingBar(100);