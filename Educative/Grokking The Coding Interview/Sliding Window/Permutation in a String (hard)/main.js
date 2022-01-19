const find_permutation = function(str, pattern) {
  const patternMap = {};
  let patternFreq = pattern.length;
  let windowStart = 0;
  for(let i = 0; i < pattern.length; i++) {
    const patternChar = pattern.charAt(i);
    if (!patternMap[patternChar]) patternMap[patternChar] = 0;
    patternMap[patternChar] += 1;
  }

  for(let i = 0; i < str.length; i++) {
    const char = str.charAt(i);
    if (patternMap[char] > 0) {
      patternMap[char] -= 1;
      patternFreq--;
    } else {
      while (patternFreq !== pattern.length) {
        const charToPutBack = str.charAt(windowStart++);
        if (patternMap[charToPutBack] >= 0) {
          patternMap[charToPutBack] += 1;
        }
        patternFreq++;
      }
    }
    if (patternFreq === 0) return true;
  }
  return patternFreq === 0;
};
