function solve(speed, area) {
  
  let speedLimit;

  switch (area) {
    case "motorway":
      speedLimit = 130;
      break;
    case "interstate":
      speedLimit = 90;
      break;
    case "city":
      speedLimit = 50;
      break;
    case "residential":
      speedLimit = 20;
      break;
  }

  if (speed <= speedLimit) {
    console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
  } else {
    let status = "";
    let difference = speed - speedLimit;

    if (difference > 0 && difference <= 20) {
      status += "speeding";
    } else if (difference > 20 && difference <= 40) {
      status += "excessive speeding";
    } else if (difference > 40) {
      status += "reckless driving";
    }

    console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`);
  }
}

solve(21, 'residential');
