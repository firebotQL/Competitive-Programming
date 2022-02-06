export function encode ( str:String, n:number):number[] {
 const narray: number[] = ('' + n).split('').map((character) => Number(character));
 return str.split('').map((character: string) => {
   return character.charCodeAt(0) - 'a'.charCodeAt(0) + 1;
 }).map((num: number, index: number) => {
   return num + narray[index % narray.length];
 });
}
