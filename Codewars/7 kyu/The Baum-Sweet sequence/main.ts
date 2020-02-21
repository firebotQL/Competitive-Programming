export function* baumSweet(): Generator {
  let num: number = 0;
  while(true) {
    const result = num.toString(2).split('').every((el: string, idx: number, arr: string[]) => {
        return idx + 1 === arr.length || !(el === '0' && el === arr[idx + 1]);
    }) ? 1 : 0;
    console.log(`Value: ${num} Binary: ${num.toString(2)} Consecutive: ${result}`);
    num++;
    yield result;
  }
}
