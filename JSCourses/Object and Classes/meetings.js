function meetings(inputArr) {

    let meetingSchedule = {};
    for (const line of inputArr) {
        let [day, name] = line.split(' ');

        
        if (!meetingSchedule.hasOwnProperty(day)) {
            meetingSchedule[day] = name;
            console.log(`Scheduled for ${day}`);
        } else {
            console.log(`Conflict on ${day}!`);
        }
    }

    for (const key in meetingSchedule) {
      console.log(`${key} -> ${meetingSchedule[key]}`);
    }
}

meetings(['Friday Bob',

'Saturday Ted',

'Monday Bill',

'Monday John',

'Wednesday George']);