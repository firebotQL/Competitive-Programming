export class G964 {
  public static listSquaredFnVersion = (m: number, n: number) => {
    return Array.from(Array(n - m + 1), (x, i) => i + m)
      .reduce((result, num) => {
        const sum = Array.from(Array(num), (x, i) => i + 1)
          .reduce((sum, cur) => {
            return sum + ((num % cur === 0) ? cur * cur : 0);
          },      0);
        if (Math.sqrt(sum) % 1 === 0) result.push([num, sum]);
        return result;
      },      []);
  }

  public static listSquared = (m: number, n: number) => {
    const result: number[][] = [];
    for (let i = m; i <= n; i += 1) {
      let sum = 0;
      for (let j = 1; j <= i; j += 1) {
        if (i % j === 0) {
          sum += j * j;
        }
      }
      if (Math.sqrt(sum) % 1 === 0) {
        result.push([i, sum]);
      }
    }
    return result;
  }
}
