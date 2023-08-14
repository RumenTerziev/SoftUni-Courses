function attachEvents() {
        const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';

    const allDomElements = {
        divRoot: document.getElementById('root'),
        form: document.querySelector('#root > form'),
        title: document.getElementById('title'),
        addButton: document.getElementById('add-button'),
        loadButton: document.getElementById('load-button'),
        unorderedList: document.getElementById('todo-list')
    }

    let mayVar = 'pesho';
    mayVar = 5;
    mayVar = 'gosho';
    mayVar = {};
    mayVar.key = 5;
    mayVar.name = 'asd';


    allDomElements.addButton.addEventListener('click', addButtonHandler);
    allDomElements.loadButton.addEventListener('click', loadButtonHandler);




    function addButtonHandler(event) {
        if (event) {
        event.preventDefault();
        }


        let payload = JSON.stringify({
            name: allDomElements.title.value
        });

        let headers = {
            method: 'POST',
            body: payload
        }


        fetch(BASE_URL, headers)
        .then(() => loadButtonHandler())
        .catch((err) => {
            console.error(err);
        });

        allDomElements.title.value = '';


    }



    function loadButtonHandler(event) {
        if (event) {
        event.preventDefault();
        }
        fetch(BASE_URL)
        .then((resp) => resp.json())
        .then((data) => {

            allDomElements.unorderedList.innerHTML = '';
            for (const key in data) {
              let {name, _id} = data[key];
              let li = createElement('li', null, allDomElements.unorderedList, _id);
              let span = createElement('span', `${name}`, li);
              let removeButton = createElement('button', 'Remove', li);
              let editButton = createElement('button', 'Edit', li);
                
              removeButton.addEventListener('click', removeButtonHandler);
              editButton.addEventListener('click', editButtonHandler);
            }

        })
        .catch((err) => {
            console.error(err);
        });
    }



    function removeButtonHandler(event) {
        event.preventDefault();
        
        let id = this.parentNode.id;

        let headers = {
            method: 'DELETE'
        }

        fetch(`${BASE_URL}${id}`, headers)
        .then(() => loadButtonHandler())
        .catch((err) => {
            console.error(err);
        });
    }

    function editButtonHandler(event) {
        event.preventDefault();

        let li = this.parentNode;
        let id = li.id;
        let span = li.querySelector('span');
        let initialValue = span.textContent;

        let newInput = createElement('input', `${initialValue}`, li);
        let submitBUtton = createElement('button', 'Submit', li);

        span.remove();
        this.remove();
        submitBUtton.addEventListener('click', submitHandler);


        function submitHandler(event) {
            event.preventDefault();

            let payload = JSON.stringify({
                name: newInput.value
            });
    
            let headers = {
                method: 'PATCH',
                body: payload
            }


            fetch(`${BASE_URL}${id}`, headers)
            .then(() => {
                loadButtonHandler()
            })
            .catch((err) => {
                console.error(err);
            });
        }
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

attachEvents();
