export class Kata {
    public static bonusTime(salary:number, bonus:boolean):string {
      return `£${salary * (bonus ? 10 : 1)}`;
    }
}
