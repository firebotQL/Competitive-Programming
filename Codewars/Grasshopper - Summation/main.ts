export const summation = (num:number)=> { 
  return [...Array(num + 1).keys()].reduce((sum:number, idx:number)=>sum + idx, 0);
}
