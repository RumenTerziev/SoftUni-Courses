function solve() {
  const output = document.getElementById('output');
  let array = document.getElementById('input').value.split('.');
  array.pop();

  while(array.length > 0) {
    let currentThree = array.splice(0, 3).map(e => e.trimStart());
    let paragraph = document.createElement('p');
    paragraph.textContent = currentThree.join('.') + '.';
    output.appendChild(paragraph);
  
  }
  findSth();
}

function findSth() {
  let myVariable = 5;

  console.log(`Found ${myVariable}`);
}