function colorize() {

    let tdArray = Array.from(document.querySelectorAll('tr:nth-child(even)'));
    tdArray.forEach(td => td.style.backgroundColor = 'teal');
}