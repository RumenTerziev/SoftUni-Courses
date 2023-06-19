function subtract() {
    let first = document.getElementById('firstNumber').value;
    let second = document.getElementById('secondNumber').value;

    let resultDiv = document.getElementById('result');
    resultDiv.textContent = first - second;

}