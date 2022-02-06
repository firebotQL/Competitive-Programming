export function nerdify(txt: string): string {
  return txt.replace(/a|A/g, '4').replace(/e|E/g, '3').replace(/l/g, '1');
}
