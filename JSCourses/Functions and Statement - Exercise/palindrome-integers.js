function solve(numbersArr) {


    for (let index = 0; index < numbersArr.length; index++) {
        
        let currentNum = numbersArr[index];
        let numbers = getCurrentNumbers(currentNum);    
    
        let isPalindrome = checkIfIsPalindrome(numbers);

        console.log(isPalindrome);

    }



    function getCurrentNumbers(number) {
        let numbers = [];

    
        while (number > 0) {
    
            let lastDigit = number % 10;
    
            numbers.push(lastDigit);
    
           number = Math.trunc(number / 10);
        }
        
        return numbers;
    }

   

    function checkIfIsPalindrome(numbers) {

        let finalCase;
    
        if (numbers.length % 2 == 0) {
            finalCase = 0;
        } else {
            finalCase = 1;
        }

        let isValid = true;
        while (numbers.length > finalCase) {
    
            let firstNum = numbers.pop();
            let secondNum = numbers.shift();
    
            if (firstNum !== secondNum) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}

solve([123,323,421,121]);