function halvesAreAlike(s: string): boolean {
  const vowels = new Set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]);
  let leftVowelsCount = 0;
  let rightVowelsCount = 0;
  for (let i = 0; i < s.length / 2; i++) {
    leftVowelsCount += vowels.has(s[i]) ? 1 : 0;
    rightVowelsCount += vowels.has(s[s.length - 1 - i]) ? 1 : 0;
  }
  return leftVowelsCount === rightVowelsCount;
}
