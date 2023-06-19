function solve (number) {


    let evenSum = 0;
    let oddSum = 0;

    while (number > 0) {

        let lastDigit = number % 10;

        if (lastDigit % 2 == 0) {
            evenSum += lastDigit;
        } else {
            oddSum += lastDigit;
        }


       number = Math.trunc(number / 10);
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

solve(1000435);