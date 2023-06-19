function addItem() {
   
        const input = document.getElementById('newItemText');
        const unorderdList = document.getElementById('items');
        let newItem = input.value;
    
        let newLi = document.createElement('li');
        let deleteButton = document.createElement('a');
        deleteButton.textContent = '[Delete]';
        deleteButton.href = '#';
        newLi.textContent = newItem;
        newLi.appendChild(deleteButton);
        unorderdList.appendChild(newLi);    

        input.value = '';

        deleteButton.addEventListener('click', deleteHandler);

      function deleteHandler() {
        deleteButton.parentElement.remove();
      }
    
}