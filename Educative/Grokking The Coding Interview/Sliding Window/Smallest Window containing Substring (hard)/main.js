const find_substring = function(str, pattern) {
  const charMap = {};
  for(let i = 0; i < pattern.length; i++) {
      const char = pattern[i];
      if (!charMap[char]) charMap[char] = 0;
      charMap[char] += 1;
  }

  let matching = 0,
      startIndex = 0,
      windowStart = 0,
      minLength = str.length + 1;
  for (let windowEnd = 0; windowEnd < str.length; windowEnd++) {
    const rightChar = str[windowEnd];
    if (rightChar in charMap) {
      charMap[rightChar] -= 1;
      if (charMap[rightChar] >= 0) {
        matching++;
      }
    }

    while(matching === pattern.length) {
      if (minLength > windowEnd - windowStart + 1) {
        minLength = windowEnd - windowStart + 1;
        startIndex = windowStart
      }

      const leftChar = str[windowStart++];
      if (leftChar in charMap) {
        if (charMap[leftChar] === 0) {
          matching--;
        }
        charMap[leftChar] += 1;
      }
    }
  }
  if (minLength > str.length) return "";

  return str.substring(startIndex, windowStart + minLength);
}
