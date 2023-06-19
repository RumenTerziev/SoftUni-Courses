function solve(text) {
    let output = "";
  
    for (const symbol of text) {
      let asciCode = symbol.charCodeAt(0);
      if (asciCode >= 65 && asciCode <= 90) {
        if (output.length > 0) {
          output += ", ";
        }
        output += symbol;
      } else {
        output += symbol;
      }
    }
  
    console.log(output);
  }

  solve('SplitMeIfYouCan');