window.addEventListener('load', solve);

function solve() {

    const inputDomElements = {
        genre: document.getElementById('genre'),
        name: document.getElementById('name'),
        author: document.getElementById('author'),
        date: document.getElementById('date')
    }

    const otherDomElements = {
        wrapper: document.getElementById('wrapper'),
        addButton: document.getElementById('add-btn'),
        allHitsContainer: document.getElementsByClassName('all-hits-container')[0],
        savedContainer: document.getElementsByClassName('saved-container')[0],
        totalLikes: document.querySelector('#total-likes > .likes > p')
    }


    let totalLikes = 0;

    otherDomElements.addButton.addEventListener('click', addButtonHandler); 



    function addButtonHandler(event) {
        event.preventDefault();

        let allFilled = Array.from(Object.values(inputDomElements))
        .every((input) => input.value !== '');

        if (!allFilled) {
            return;
        }


        let hitsInfo = createElement('div', '', otherDomElements.allHitsContainer, null, ['hits-info']);
        let img = createElement('img', '', hitsInfo, null, null, {src: "./static/img/img.png"});
        createElement('h2', `Genre: ${inputDomElements.genre.value}`, hitsInfo);
        createElement('h2', `Name: ${inputDomElements.name.value}`, hitsInfo);
        createElement('h2', `Author: ${inputDomElements.author.value}`, hitsInfo);
        createElement('h3', `Date: ${inputDomElements.date.value}`, hitsInfo);
        let saveButton = createElement('button', 'Save song', hitsInfo, null, ['save-btn']);
        let likeButton = createElement('button', 'Like song', hitsInfo, null, ['like-btn']);
        let deleteButton = createElement('button', 'Delete', hitsInfo, null, ['delete-btn']);

        saveButton.addEventListener('click', saveButtonHandler);
        likeButton.addEventListener('click', likeButtonHandler);
        deleteButton.addEventListener('click', deleteButtonHandler);

        Array.from(Object.values(inputDomElements))
        .forEach((e) => e.value = '');

    }



    function saveButtonHandler() {

    let songRef = otherDomElements.allHitsContainer.querySelector('.hits-info');
    console.log(songRef);
    otherDomElements.savedContainer.appendChild(songRef);

    songRef.querySelector('.like-btn').remove();
    songRef.querySelector('.save-btn').remove();

}

    function likeButtonHandler() {
        totalLikes++;
        this.setAttribute('disabled', true);
        otherDomElements.totalLikes.textContent = `Total Likes: ${totalLikes}`;
    }


    function deleteButtonHandler() {
        this.parentNode.remove();
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