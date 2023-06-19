function oddOccurences(input) {
  let strings = input.split(" ");

  let occurrences = [];
  for (const string of strings) {
    let current = string.toLowerCase();

    let word = occurrences.find((w) => w.key === current);
    if (word == null) {
      occurrences.push({ key: current, value: 1 });
    } else {
      word.value = word.value + 1;
    }
  }

  let words = [];
  let filtered = occurrences.filter((e) => e.value % 2 != 0).forEach(element => words.push(element.key));
  console.log(words.join(' '));

}

oddOccurences("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
