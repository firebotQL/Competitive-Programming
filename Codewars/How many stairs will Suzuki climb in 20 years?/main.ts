export function stairsIn20(stairs: any[]) {
  return [].concat(...stairs).reduce((sum, cur) => sum + cur, 0) * 20;
}
