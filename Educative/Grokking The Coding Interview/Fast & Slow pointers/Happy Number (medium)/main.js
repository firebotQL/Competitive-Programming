const find_happy_number = function(num) {
  let slow = num, fast = num;
  do {
      slow = calc(slow);
      fast = calc(calc(fast));
      if (fast === 1) return true;
  } while (slow !== fast)
  return false;
};

const calc = (num) => {
  return `${num}`.split('').reduce((result, curNumber) => result + (curNumber * curNumber), 0);
}

const calc2 = (num) => {
    let sum = 0;
    while ((num > 0)) {
        digit = num % 10;
        sum += digit * digit;
        num = Math.floor(num / 10);
    }
    return sum;
}

console.log(`${find_happy_number(23)}`)
console.log(`${find_happy_number(12)}`)
