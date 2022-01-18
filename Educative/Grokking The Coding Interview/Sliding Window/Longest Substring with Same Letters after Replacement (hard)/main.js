const length_of_longest_substring = function(str, k) {
  const charMap = {};
  let maxLength = Number.MIN_SAFE_INTEGER, maxCharFreq = Number.MIN_SAFE_INTEGER;
  let windowStart = 0;
  for(let i = 0; i < str.length; i++) {
    const char = str.charAt(i);
    if (!charMap[char]) charMap[char] = 0;
    charMap[char] += 1;

    maxCharFreq = Math.max(maxCharFreq, charMap[char]);

    if ((i - windowStart + 1 - maxCharFreq) > k) {
      const charToRemove = str.charAt[windowStart];
      charMap[charToRemove] -= 1;
      windowStart += 1;
    }

    maxLength = Math.max(maxLength, i - windowStart + 1);

  }
  return maxLength;
};
