export class Kata {
    public static buildString(... template:string[]):string {
        return `I like ${template.join(', ')}!`
    }
}
