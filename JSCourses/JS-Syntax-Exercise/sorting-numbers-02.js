function solve(array) {
    array.sort((first, second) => first - second);
  
    let newArr = [];
  
    for (let index = 0; index < array.length / 2; index++) {
      newArr.push(array[index]);
      if (index == Math.trunc(array.length / 2)) {
        break;
      }
      newArr.push(array[array.length - 1 - index]);
    }
  
    return newArr;
  }

  console.log(solve([1, 65, 3, 52, 48, 64, 63, 31, -3, 18, 56]));