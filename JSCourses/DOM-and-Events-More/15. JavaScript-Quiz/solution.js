function solve() {

  const sections = Array.from(document.getElementsByTagName('section'));
  const first = sections[0];
  const second = sections[1];
  const third = sections[2];
  const resultUl = document.getElementById('results');
  const resultLi = document.getElementsByClassName('results-inner')[0];
  const resultH1 = resultLi.querySelector('h1');
  
  const optionsFirst = Array.from(first.querySelectorAll('p')); 
  const firstRight = optionsFirst[0];
  const firstWrong = optionsFirst[1];


  const optionsSecond = Array.from(second.querySelectorAll('p')); 
  const secondRight = optionsSecond[1];
  const secondWrong = optionsSecond[0];

  const optionsThird = Array.from(third.querySelectorAll('p')); 
  const thirdRight = optionsThird[0];
  const thirdWrong = optionsThird[1];


  firstRight.addEventListener('click', rightHandler);
  firstWrong.addEventListener('click', wrongHandler);

  secondRight.addEventListener('click', rightHandler);
  secondWrong.addEventListener('click', wrongHandler);

  thirdRight.addEventListener('click', rightHandler);
  thirdWrong.addEventListener('click', wrongHandler);


  let countAnswers = 0;
  let countRightAnswers = 0;

  

function rightHandler() {
  countAnswers++;
  countRightAnswers++;

  changeScreen(countAnswers);
  result(countAnswers, countRightAnswers);
}

function wrongHandler() {
  countAnswers++;

  changeScreen(countAnswers);
  result(countAnswers, countRightAnswers);
}


function changeScreen(count) {
  if (count === 1) {
    first.style.display = 'none';
    second.style.display = 'block';
  } else if (count === 2) {
    second.style.display = 'none';
    third.style.display = 'block';
  } else if (count === 3) {
    third.style.display = 'none';
  }
}


function result(answers, rightAnswers) {

  let result = '';

  if (answers === 3 && rightAnswers === 3) {
    result = 'You are recognized as top JavaScript fan!';
  } else if (answers === 3 && rightAnswers < 3) {
    result = `You have ${rightAnswers} right answers`;
  }

  if (answers === 3) {
    resultUl.style.display = 'block';
    resultH1.textContent = result;
  }
}

}