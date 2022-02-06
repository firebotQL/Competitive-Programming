export function mod256WithoutMod(n:number):number
{
  const fn = n < 0 ? Math.ceil : Math.floor
  return n - (fn(n / 256) * 256);
}
