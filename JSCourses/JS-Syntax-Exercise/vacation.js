function solve(peopleCount, typeOfGroup, dayOfWeek) {


    let price;
    let totalPrice;

  switch (typeOfGroup) {


    case "Students":

        if (dayOfWeek === 'Friday') {
            price = 8.45;

        } else if (dayOfWeek === 'Saturday') {
            price = 9.80;
        } else if (dayOfWeek === 'Sunday') {
            price = 10.46;
        }

        totalPrice = price * peopleCount;

        if (peopleCount >= 30) {
            totalPrice = totalPrice - totalPrice * 0.15;
        }

      break;
    case "Business":

    if (dayOfWeek === 'Friday') {

        price = 10.90;
    } else if (dayOfWeek === 'Saturday') {

        price = 15.60;
    } else if (dayOfWeek === 'Sunday') {
        price = 16;
    }

    if (peopleCount >= 100) {
        peopleCount = peopleCount - 10;
    }
    totalPrice = price * peopleCount;


      break;
    case "Regular":

    if (dayOfWeek === 'Friday') {

        price = 15;
    } else if (dayOfWeek === 'Saturday') {
        price = 20;
    } else if (dayOfWeek === 'Sunday') {
        price = 22.50;
    
    }

    totalPrice = price * peopleCount;
    if (peopleCount >= 10 && peopleCount <= 20) {
        totalPrice = totalPrice - totalPrice * 0.05;
    }

      break;


  }

  console.log(`Total price: ${totalPrice.toFixed(2)}`);

}

solve(30,

    "Students",
    
    "Sunday");
