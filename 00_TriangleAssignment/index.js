let ctrl = {};

//RETURN THE TYPE OF THE TRIANGLE, else INVALID
ctrl.typeOfTriangle = function(x, y, z) {
  if (ctrl.check(x) == 'OK' && ctrl.check(y) == 'OK' && ctrl.check(z) == 'OK') {
    x = Number(x);
    y = Number(y);
    z = Number(z);
    if (ctrl.isValidSideLength(x, y, z)) {
      return ctrl.getTriangle(x, y, z);
    } else {
      return 'invalid';
    }
  } else {
    return 'invalid';
  }
}

//CHECK IF INPUT IS VALID
ctrl.check = function(num) {
  let stat = '';
  if (num != undefined) {
    num = Number(num);
    if (isNaN(num)) {
      stat += 'Not a Number! '
    }
  } else {
    stat += 'Missing side length! '
  }
  if (stat == '') {
    return 'OK'
  }
  return stat;
}

ctrl.isValidSideLength = function(a, b, c) {
  if (a + b > c && a + c > b && b + c > a) {
    return true;
  } else {
    return false;
  }
}

ctrl.getTriangle = function(x, y, z) {
  if (x == y && y == z) {
    return 'equilateral';
  } else if (x != y && y != z && x != z) {
    return 'scalene';
  } else {
    return 'isosceles';
  }
}



//MAIN:
let input = process.argv;
// console.log('INPUT: ' + input);
let x = input[2];
let y = input[3];
let z = input[4];
let res = ctrl.typeOfTriangle(x, y, z);
console.log('The triangle is ' + res);

module.exports = ctrl;
