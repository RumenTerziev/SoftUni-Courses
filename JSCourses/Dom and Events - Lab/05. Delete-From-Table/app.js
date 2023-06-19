function deleteByEmail() {

    const inputItem = document.getElementsByTagName('input')[0];
    let tdElements = Array.from(document.querySelectorAll('tbody > tr > td:nth-child(even)'));


    let isRremoved = false;
    for (const element of tdElements) {
        if (element.textContent === inputItem.value) {
            element.parentElement.innerHTML = '';
            inputItem.value = '';
            isRremoved = true;
            break;
        }
    }

    const div = document.getElementById('result');
    if (isRremoved) {
        div.textContent = 'Deleted.';
    } else {
        div.textContent = 'Not found.'
    }

}