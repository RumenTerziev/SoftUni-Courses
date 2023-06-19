function addItem(newItemText, newItemValue) {
    newItemText = document.getElementById('newItemText');
    newItemValue = document.getElementById('newItemValue');
    let menu = document.getElementById('menu');
 
    let option = document.createElement('option');
    option.textContent = newItemText.value;
    option.value = newItemValue.value;
    menu.appendChild(option);

    newItemText.value = '';
    newItemValue.value = '';
}