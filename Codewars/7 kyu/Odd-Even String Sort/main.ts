export function sortMyString(S:string):string {
  const even = (el,idx) => idx % 2 === 0;
  const odd = (el,idx) => idx % 2 !== 0;
  return `${S.split('').filter(even).join('')} ${S.split('').filter(odd).join('')}`;
}
