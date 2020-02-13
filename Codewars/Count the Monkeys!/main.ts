export function monkeyCount(n: number) {
   return [...Array(n).keys()].map((el) => el + 1);
}
