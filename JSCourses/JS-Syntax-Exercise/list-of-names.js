function solve(array) {

  return [...array]
    .sort((first, second) => first.localeCompare(second))
    .map((element, index) => `${index + 1}.${element}`)
    .join("\n");
}

console.log(solve(["John", "Bob", "Christina", "Ema"]));
