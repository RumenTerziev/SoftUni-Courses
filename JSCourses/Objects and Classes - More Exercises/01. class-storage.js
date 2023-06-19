class Storage {
    constructor (capacity) {
        this.capacity = capacity;
        this.storage = {};
        this.totalCost = 0;
    }


     addProduct(product) {

         if (this.capacity > 0 && product.quantity > 0 && this.capacity - product.quantity >= 0) {
             if (!this.storage.hasOwnProperty(product.name)) {
            this.storage[product.name] = product;
          
        } else {
            this.storage[product.name].quantity += product.quantity;
        }

        this.capacity -= product.quantity;
        this.totalCost += product.price * product.quantity;
    } 
     
    }

    getProducts() {
        let result = '';
        for (const key in this.storage) {
            result += JSON.stringify(this.storage[key]);
            result += '\n';
        }
      return result.trim();
    }
    
}


let productOne = {name: 'Cucamber',

price: 1.50, quantity: 15};

let productTwo = {name: 'Tomato', price:

0.90, quantity: 25};

let productThree = {name: 'Bread', price:

1.10, quantity: 8};

let storage = new Storage(50);

storage.addProduct(productOne);

storage.addProduct(productTwo);

storage.addProduct(productThree);

console.log(storage.getProducts());

console.log(storage.capacity);

console.log(storage.totalCost);




// let productFour = {name: 'Carrot', price:

// 0.90, quantity: 19};

// let productFive = {name: 'Potato', price:

// 1.10, quantity: 10};

// storage.addProduct(productFour);

// storage.addProduct(productFive);


// console.log(storage.getProducts());

// console.log(storage.capacity);

// console.log(storage.totalCost);