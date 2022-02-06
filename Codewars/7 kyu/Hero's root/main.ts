export class G964 {
    public static intRac(n: number, guess: number): number {
        let previousGuess: number;
        let count:number = 0;
        do {
          previousGuess = guess;
          guess = Math.floor((guess + n/guess)/2);
          count++;
        } while(Math.abs(previousGuess - guess) >= 1);
        return count;
    }
}
