export function getNewNotes(salary:number,bills:number[]):number{
  const moneyLeft = bills.reduce((money, bill) => money - bill, salary);
  return Math.floor(moneyLeft >= 5 ? moneyLeft / 5 : 0);
}
