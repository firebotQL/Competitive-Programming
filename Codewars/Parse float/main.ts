export function parseF(s:string):number {
  return isNaN(Number(s)) ? null : Number(s);
}
