function solve() {

  const [generateArea, buyArea] = Array.from(document.getElementsByTagName('textarea'));
  const [generateButton, buyButton] = Array.from(document.getElementsByTagName('button'));
  const tbody = document.querySelector('.table > tbody');

  generateButton.addEventListener('click', generateHandler);
  buyButton.addEventListener('click', buyHandler);


  function generateHandler() {
    const data = JSON.parse(generateArea.value);

    for (const {img, name, price, decFactor} of data) {
     const tableRow = createElement('tr','', tbody);
     const firstCol = createElement('td', '', tableRow);
     createElement('img', '', firstCol, '', '', {src: img}); 
     const secondCol = createElement('td', '', tableRow);
     createElement('p', name, secondCol);
     const thirdCol = createElement('td', '', tableRow);
     createElement('p', price, thirdCol);
     const fourthCol = createElement('td', '', tableRow);
     createElement('p', decFactor, fourthCol);
     const fifthCol = createElement('td', '', tableRow);
     createElement('input', '', fifthCol, '', '', {type: 'checkbox'});
    }
  }


  function buyHandler() {
    const allChecked = Array.from(document.querySelectorAll('tbody tr input:checked'));
    
    let boughtItems = [];
    let totalPrice = 0;
    let totalDecFactor = 0;

    for (const input of allChecked) {
      const tableRow = input.parentElement.parentElement;
      const [_firstColumn, secondColumn, thirdColumn, fourthColumn] = Array.from(tableRow.children);
      let item = secondColumn.children[0].textContent;
      boughtItems.push(item);
      let currentPrice = Number(thirdColumn.children[0].textContent);
      totalPrice += currentPrice;
      let currentDecFactor = Number(fourthColumn.children[0].textContent);
      totalDecFactor += currentDecFactor;
    }

    buyArea.value += `Bought furniture: ${boughtItems.join(', ')}\n`;
    buyArea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    buyArea.value += `Avarage decoration factor: ${totalDecFactor/ allChecked.length}`;
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

