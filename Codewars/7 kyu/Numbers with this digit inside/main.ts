export function numbersWithDigitInside(x:number, d:number):number[] {
  return [...Array(x + 1).keys()]
  .filter((num) => num !== 0 && num.toString().indexOf(d.toString()) > -1)
  .reduce((result, cur) => {
    result[0] += 1;
    result[1] += cur;
    if (result[2] === 0) result[2] = 1;
    result[2] *= cur;
    return result;
  }, [0, 0, 0]);
}
