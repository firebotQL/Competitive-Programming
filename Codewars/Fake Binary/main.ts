export const fakeBin = (x:string):string => {
  return x.split('').map((x) => parseInt(x) < 5 ? '0' : '1').join('');
};
