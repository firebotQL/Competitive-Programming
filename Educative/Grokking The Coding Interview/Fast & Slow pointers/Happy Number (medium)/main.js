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


console.log(`${find_happy_number(23)}`)
console.log(`${find_happy_number(12)}`)
