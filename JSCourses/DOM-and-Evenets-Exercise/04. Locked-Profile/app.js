function lockedProfile() {
    
    const buttons = Array.from(document.getElementsByTagName('button'));
    buttons.forEach(btn => btn.addEventListener('click', buttonHandler));

    const inputs = Array.from(document.querySelectorAll('input'));
    let radios = inputs.filter(input => input.type === 'radio');


    function buttonHandler() {
        let divUser = this.parentElement;
        let hiddenDiv = divUser.children[9];
        
        if (divUser.children[4].checked == true) {
            if (this.textContent === 'Show more') {
                hiddenDiv.style.display = 'block';
                this.textContent = 'Hide it';
            } else {
                hiddenDiv.style.display = 'none';
                this.textContent = 'Show more';
            }
        }
    
    }

}