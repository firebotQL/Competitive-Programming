export function comp(a1: number[] | null, a2: number[] | null): boolean {
   if (!a1 || !a2 || a1.length != a2.length) return false;
   a1.sort();
   a2.sort();
   return !a1.some((element, index) => (element * element) !== a2[index]);
}
