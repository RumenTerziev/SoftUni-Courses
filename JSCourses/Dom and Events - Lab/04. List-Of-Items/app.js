function addItem() {
    const input = document.getElementById('newItemText');
    const unorderdList = document.getElementById('items');
    let newItem = input.value;

    let newLi = document.createElement('li');
    newLi.textContent = newItem;
    unorderdList.appendChild(newLi);    
    input.value = '';
}