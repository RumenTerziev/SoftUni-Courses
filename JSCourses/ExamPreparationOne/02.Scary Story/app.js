window.addEventListener("load", solve);

function solve() {

  const inputDomElements = {
    firstName: document.getElementById('first-name'),
    lastName: document.getElementById('last-name'),
    age: document.getElementById('age'),
    storyTitle: document.getElementById('story-title'),
    storyText: document.getElementById('story')
  }


  const otherDomElements = {
    genre: document.getElementById('genre'),
    publish: document.getElementById('form-btn'),
    previewList: document.getElementById('preview-list'),
    main: document.getElementById('main')
  }


otherDomElements.publish.addEventListener('click', publishHandler);

let currentState = {};

function publishHandler(event) {
  event.preventDefault();


  let areAllFilled = Array.from(Object.values(inputDomElements))
  .every((element) => element.value !== '');


  if (!areAllFilled) {
    return;
  }

  let li = createElement('li', '',otherDomElements.previewList, '', ['story-info']);
  let article = createElement('article', '', li);
  createElement('h4',`Name: ${inputDomElements.firstName.value} ${inputDomElements.lastName.value}`, article);
  createElement('p', `Age: ${inputDomElements.age.value}`, article);
  createElement('p', `Title: ${inputDomElements.storyTitle.value}`, article);
  createElement('p', `Genre: ${otherDomElements.genre.value}`, article);
  createElement('p', `${inputDomElements.storyText.value}`, article);
  let saveButton = createElement('button', 'Save Story', li, '', ['save-btn']);
  let editButton = createElement('button', 'Edit Story', li, '', ['edit-btn']);
  let deleteButton = createElement('button', 'Delete Story', li, '', ['delete-btn']);

  saveButton.addEventListener('click', saveHandler);
  editButton.addEventListener('click', editHandler);
  deleteButton.addEventListener('click', deleteHandler);

  otherDomElements.publish.setAttribute('disabled', true);

  for (const key in inputDomElements) {
    currentState[key] = inputDomElements[key].value;
   }

    Array.from(Object.values(inputDomElements)).forEach((element) => element.value = '');
}


function saveHandler() {

  otherDomElements.main.innerHTML = '';
  createElement('h1', 'Your scary story is saved!', otherDomElements.main);

}


function editHandler() {

 for (const key in inputDomElements) {
  inputDomElements[key].value = currentState[key];
 }

  this.parentNode.remove();
  otherDomElements.publish.removeAttribute('disabled');
}


function deleteHandler() {
  this.parentNode.remove();
  otherDomElements.publish.removeAttribute('disabled');
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