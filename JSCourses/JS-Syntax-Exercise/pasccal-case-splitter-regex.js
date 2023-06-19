function solve(text) {
  

    const re = /([A-Z][a-z]*)/gm;

    let result = text.match(re);

    let output = [];
    for (const word of result) {
        output.push(word);
    }

  
    console.log(output.join(', '));
  }

  solve('SplitMeIfYouCanHaHaYouCantOrYouCan');