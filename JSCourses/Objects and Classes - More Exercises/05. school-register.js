function school(input) {

    let allGrades = [];
    let allStudents = {};
    for (const line of input) {
        let infoArray = line.split(', ');
        let [nameInfo, gradeInfo, scoreInfo] = infoArray;
        let name = nameInfo.split(': ')[1];
        let grade = gradeInfo.split(': ')[1];
        let score = scoreInfo.split(': ')[1];


        if (!allGrades.includes(grade)) {
            allGrades.push(grade);
        }

        let studentInfo = {
            name,
            grade,
            score
        }
        
        if (!allStudents.hasOwnProperty(grade)) {
            allStudents[grade] = [];
        }

        allStudents[grade].push(studentInfo);

    }


    allGrades.sort((f, s) => f - s);

    
    let output = '';
    for (const searchedGrade of allGrades) {
       
       
        for (const studentGrade in allStudents) {
         
            let names = [];
            let sum = 0;
            if (searchedGrade === studentGrade) {

                for (const student of allStudents[studentGrade]) {
                    let {name, grade, score} = student;
                    if (score >= 3) {
                        names.push(name);
                        sum += Number(score);
                    }
                }

                  if (names.length > 0) {
                   let nextGrade = Number(searchedGrade) + 1;
                   output += `${nextGrade} Grade\n`;
                   let avarage = sum / names.length;
                   output += `List of students: ${names.join(', ')}\n`;
                   output += `Average annual score from last year: ${avarage.toFixed(2)}\n`;
                   output += '\n';
                  }
                  
            }
          

        }

    }
    console.log(output.trim());
}

school([

    "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
    
    "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
    
    "Student name: George, Grade: 8, Graduated with an average score: 2.83",
    
    "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
    
    "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
    
    "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
    
    "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
    
    "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
    
    "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
    
    "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
    
    "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
    
    "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00"
    
    ]);


// school([
//     'Student name: George, Grade: 5, Graduated with an average score: 2.75',
//     'Student name: Alex, Grade: 9, Graduate with an average score: 3.66',
//      'Student name: Peter, Grade: 8, Graduated with an average score: 2.83', 
//      'Student name: Boby, Grade: 5, Graduated with an average score: 4.20', 
//      'Student name: John, Grade: 9, Graduated with an average score: 2.90', 
//      'Student name: Steven, Grade: 2, Graduated with an average score: 4.90', 
//      'Student name: Darsy, Grade: 1, Graduated with an average score: 5.15' ]
//     );