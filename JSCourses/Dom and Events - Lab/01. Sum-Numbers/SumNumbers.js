function calc() {
    const firstNum = document.getElementById('num1');
    const secondNum = document.getElementById('num2');
    const sum = document.getElementById('sum');

    sum.value = Number(firstNum.value) + Number(secondNum.value);
}
