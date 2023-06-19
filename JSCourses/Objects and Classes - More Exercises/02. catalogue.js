function catalogue(input) {

    let products = [];
    for (const line of input) {
        let commandLine = line.split(' : ');
        let productName = commandLine[0];
        let productPrice = Number(commandLine[1]);
        
        let product = {
            productName,
            productPrice
        }

        products.push(product);
    }


    let letters = [];

  for (const product of products) {
    let currentLetter = product.productName.charAt(0);

     if (!letters.includes(currentLetter)) {
        letters.push(currentLetter);
     }
  }

 
 letters.sort((f, s) => f.localeCompare(s));

  for (const letter of letters) {
    console.log(letter);

    products.filter((p) => p.productName.charAt(0) === letter)
    .sort((f, s) => f.productName.localeCompare(s.productName))
    .forEach((product) => {
        console.log(`  ${product.productName}: ${product.productPrice}`);
    });
  }

}


catalogue([

    'Appricot : 20.4',
    
    'Fridge : 1500',
    
    'TV : 1499',
    
    'Deodorant : 10',
    
    'Boiler : 300',
    
    'Apple : 1.25',
    
    'Anti-Bug Spray : 15',
    
    'T-Shirt : 10'
    
    ]);