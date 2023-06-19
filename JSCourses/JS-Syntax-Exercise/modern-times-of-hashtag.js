function solve(text) {

    const re = /([#][A-Za-z]+)/gm;


    let resultArr = text.match(re);

    for (const word of resultArr) {

        console.log(word.replace('#', ''));
    }
    
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');