function store(stock, productsOrdered) {
  let combined = [...stock, ...productsOrdered];

  let storeMap = {};

  for (let index = 0; index < combined.length; index += 2) {
    let product = combined[index];
    let quantity = Number(combined[index + 1]);

    if (!storeMap.hasOwnProperty(product)) {
      storeMap[product] = quantity;
    } else {
      storeMap[product] += quantity;
    }
  }

  for (const key in storeMap) {
    console.log(`${key} -> ${storeMap[key]}`);
  }
}

store(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],

  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);
