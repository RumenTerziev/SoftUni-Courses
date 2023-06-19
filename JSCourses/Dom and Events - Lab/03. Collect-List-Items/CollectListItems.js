function extractText() {
    const listItems = Array.from(document.querySelectorAll("#items > li"));
    const resultArea = document.getElementById('result');

    listItems.forEach((li) => {
        resultArea.value += li.textContent + '\n';
    });
}