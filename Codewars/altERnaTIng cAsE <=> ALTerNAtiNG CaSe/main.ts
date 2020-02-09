export function toAlternatingCase(s: string): string {
    return s.split('').map((c) => {
      if (!/[a-zA-Z]/g.test(c)) return c;
      return c === c.toUpperCase() ? c.toLowerCase() : c.toUpperCase()
    }).join('');
}
