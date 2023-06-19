function softUni (input) {

    let courses = {};
    for (const line of input) {
        let commandLine;
        if (line.includes(': ')) {
            commandLine  = line.split(':');
            let courseName = commandLine[0];
            let courseCapacity = Number(commandLine[1]);

            if (courses.hasOwnProperty(courseName)) {
              
                courses[courseName].courseCapacity += courseCapacity;

            } else {
               
                courses[courseName] = {
                    courseCapacity,
                    courseUsers: []
                }
            }
           
           
            

        } else {
            commandLine = line.split(' ');
            let userName = commandLine[0].split('[')[0];
            let credits = commandLine[0].split('[')[1].replace(']', '');

            let courseToJoin = commandLine[commandLine.length - 1];
            let email = line.split('with email ')[1].split(' joins')[0];

            let user = {
                userName,
                credits,
                email
            }
            
            if (courses.hasOwnProperty(courseToJoin) &&  courses[courseToJoin].courseUsers.length < courses[courseToJoin].courseCapacity) {
                courses[courseToJoin].courseUsers.push(user);
            }
        }
    }


        
    
   let array =  Object.entries(courses);

   let sortedArr = array.sort((f, s) => s[1].courseUsers.length - f[1].courseUsers.length);

   for (const current of sortedArr) {
    let [key, value] = current;
    let places = value.courseCapacity - value.courseUsers.length;
    console.log(`${key}: ${places} places left`);

    let currentUsers = value.courseUsers.sort((f, s) => s.credits - f.credits);
  for (const currentUser of currentUsers) {
    let {userName, credits, email} = currentUser;
    console.log(`--- ${credits}: ${userName}, ${email}`);
  }
}

}

softUni(['JavaBasics: 2', 
'user1[25] with email user1@user.com joins C#Basics',
 'C#Advanced: 3', 
 'JSCore: 4',
'user2[30] with email user2@user.com joins C#Basics',
'user13[50] with email user13@user.com joins JSCore',
'user1[25] with email user1@user.com joins JSCore',
 'user8[18] with email user8@user.com joins C#Advanced', 
 'user6[85] with email user6@user.com joins JSCore', 'JSCore: 2',
'user11[3] with email user11@user.com joins JavaBasics',
'user45[105] with email user45@user.com joins JSCore',
'user007[20] with email user007@user.com joins JSCore',
'user700[29] with email user700@user.com joins JSCore',
'user900[88] with email user900@user.com joins JSCore']);