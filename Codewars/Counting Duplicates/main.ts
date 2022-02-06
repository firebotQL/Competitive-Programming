export function duplicateCount(text: string): number{
  const countMap: { [key: string] : number } = {}
  return Object.keys(text
         .toLowerCase()
         .split('')
         .reduce((result: { [key: string] : number }, character: string) => {
             if (!countMap[character]) countMap[character] = 0;
             countMap[character] += 1;
             return countMap;
          }, countMap))
            .filter((key) => countMap[key] > 1).length;
}
