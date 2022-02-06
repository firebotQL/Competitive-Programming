export const median = (n:number[]):number => {
  n.sort((a,b) => a - b);
  const mid = Math.floor(n.length/2);
  return n.length % 2 === 0 ? (n[mid] + n[mid - 1]) / 2 : n[mid];
}
