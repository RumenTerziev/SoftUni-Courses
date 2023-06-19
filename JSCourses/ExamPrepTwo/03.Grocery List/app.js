window.addEventListener('load', solve);

function solve() {  

    const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';


    const inputDomElements = {
        product: document.getElementById('product'),
        count: document.getElementById('count'),
        price: document.getElementById('price'),
    }


    const otherDomElements = {
        tbody: document.getElementById('tbody'),
        addProduct: document.getElementById('add-product'),
        updateProduct: document.getElementById('update-product'),
        loadProduct: document.getElementById('load-product')
    }


    otherDomElements.addProduct.addEventListener('click', addProductHandler);
    otherDomElements.updateProduct.addEventListener('click', updateProductHandler);
    otherDomElements.loadProduct.addEventListener('click', loadProductHandler);

    

    function addProductHandler(event) {
        event.preventDefault();
        
        let payload = JSON.stringify({

            product: inputDomElements.product.value,
            count: inputDomElements.count.value,
            price: inputDomElements.price.value

        });

    
        let headers = {
            method: "POST",
            body: payload
        }

        fetch(BASE_URL, headers)
        .then(() => loadProductHandler())
        .catch((err) => {
            console.error(err);
        });

        clearAllFields();
    }


  

    function loadProductHandler(event) {

        if (event) {
            event.preventDefault();
        }


        fetch(BASE_URL)
        .then((resp) => resp.json())
        .then((data) => {

            otherDomElements.tbody.innerHTML = '';

            for (const key in data) {
               let {product, count, price, _id} = data[key];

                let tr = createElement('tr', '', otherDomElements.tbody, _id);
                let nameTd = createElement('td', `${product}`, tr, null, ['name']);
                let countTd = createElement('td', `${count}`, tr, null, ['count-product']);
                let priceTd = createElement('td', `${price}`, tr, null, ['product-price']);
                let buttonTd = createElement('td', '', tr, null, ['btn']);
                let updateButton = createElement('button', 'Update', buttonTd, null, ['update']);
                let deleteButton = createElement('button', 'Delete', buttonTd, null, ['delete']);

                updateButton.addEventListener('click', updateButtonHandler);
                deleteButton.addEventListener('click', deleteButtonHandler);

            }
        })
        .catch((err) => {
            console.error(err);
        })
        clearAllFields();
    }

        let productToChange;
    function updateButtonHandler() {
         productToChange = this.parentNode.parentNode;
        inputDomElements.product.value = productToChange.querySelector('.name').textContent;
        inputDomElements.count.value = productToChange.querySelector('.count-product').textContent;
        inputDomElements.price.value = productToChange.querySelector('.product-price').textContent;

        otherDomElements.updateProduct.removeAttribute('disabled');
        otherDomElements.addProduct.setAttribute('disabled', true);
    }

    function updateProductHandler(event) {
        event.preventDefault();
        let id = productToChange.id;
        console.log(id);

        let payload = JSON.stringify({
            product: inputDomElements.product.value,
            count: inputDomElements.count.value,
            price: inputDomElements.price.value
        });

        let headers = {
            method: "PATCH",
            body: payload
        };


        fetch(`${BASE_URL}${id}`, headers)
        .then(() => loadProductHandler())
        .catch((err) => {
            console.error(err);
        });
    }

    function deleteButtonHandler() {
        let id = this.parentNode.parentNode.id;
        
        let headers = {
            method: 'DELETE'
        }

        fetch(`${BASE_URL}${id}`, headers)
        .then(() => loadProductHandler())
        .catch((err) => {
            console.error(err);
        })
    }

    function clearAllFields() {
        Array.from(Object.values(inputDomElements)).forEach((i) => i.value = '');
    }

    function createElement(type, content, parentNode, id, classes, attributes, useInnerHtml) {
    
        const htmlElement = document.createElement(type);
        
        if (content && useInnerHtml) {
          htmlElement.innerHtml = content;
        } else {
    
          if(content && type !== 'input') {
            htmlElement.textContent = content;
          }
    
          if (content && type === 'input') {
            htmlElement.value = content;
          }
        }
    
      if (id) {
        htmlElement.id = id;
      }
      
      if (classes && classes.length > 0) {
        htmlElement.classList.add(...classes);
      }
      
      
      if (attributes) {
        for (const key in attributes) {
          htmlElement.setAttribute(key, attributes[key]);
        }
      }
    
      if (parentNode) {
        parentNode.appendChild(htmlElement);
      }
      
      return htmlElement;
      }

}