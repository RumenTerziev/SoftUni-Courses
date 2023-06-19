function solve(product, quantity) {
  let price;

  switch (product) {
    case "coffee":
      price = 1.5;
      break;
    case "water":
      price = 1;
      break;
      case 'coke':
        price = 1.40;
        break;
        case 'snacks':
            price = 2;
            break;

  }

  let totalPrice = price * quantity;

  console.log(`${totalPrice.toFixed(2)}`);
}

solve("water", 5);
