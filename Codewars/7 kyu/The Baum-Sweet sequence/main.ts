export function* baumSweet(): Generator {
  yield 1;
  let num: number = 1;
  while(true) {
    yield +(num++).toString(2).split('1').every((el) => el.length % 2 === 0);
  }
}
