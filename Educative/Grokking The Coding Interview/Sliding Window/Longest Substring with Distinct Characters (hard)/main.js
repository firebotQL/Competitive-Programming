const non_repeat_substring = function(str) {
  const charMap = {};
  let startWindow = 0;
  let maxLength = Number.MIN_SAFE_INTEGER;
  for(let i = 0; i < str.length; i++) {
    const char = str.charAt(i);
    if (!charMap[char]) charMap[char] = 0;
    charMap[char] += 1;
    while(charMap[char] > 1) {
        charMap[str.charAt(startWindow++)] -= 1;
        if (charMap[char] == 0) delete charMap[char];
    }
    maxLength = Math.max(maxLength, i - startWindow + 1);
  }
  return maxLength;
};
