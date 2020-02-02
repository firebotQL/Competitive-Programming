export function repeatStr (n:number, s:String):String {
  return Array(n).fill(0).reduce((sum, cur) => sum + s, '');
}
