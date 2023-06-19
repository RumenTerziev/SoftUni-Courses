function sumTable() {
  const tdArray = Array.from(
    document.querySelectorAll("tr > td:nth-child(even)")
  );
  const result = document.getElementById("sum");

  let sum = 0;
  for (let index = 0; index < tdArray.length - 1; index++) {
    const element = tdArray[index];
    sum += Number(element.textContent);
  }

  result.textContent = sum;
}
