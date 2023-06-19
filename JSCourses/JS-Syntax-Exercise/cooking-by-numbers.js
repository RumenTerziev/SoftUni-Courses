function solve(numberString, ...operations) {
  let number = Number(numberString);

  for (let index = 0; index < operations.length; index++) {
    let operation = operations[index];

    switch (operation) {
      case "chop":
        number = number / 2;
        break;
      case "dice":
        number = Math.sqrt(number);
        break;
      case "spice":
        number++;
        break;
      case "bake":
        number = number * 3;
        break;
      case "fillet":
        number = number - number * 0.2;
        break;
    }
    console.log(number);
  }
}

solve('9', 'dice', 'spice', 'chop', 'bake','fillet');
