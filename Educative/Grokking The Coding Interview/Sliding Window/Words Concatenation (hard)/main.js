function find_word_concatenation(str, words) {
  if (words.length === 0 || words[0].length === 0) {
    return [];
  }

  let wordFrequency = {};

  words.forEach((word) => {
    if (!(wordFrequency[word])) wordFrequency[word] = 0;
    wordFrequency[word] += 1;
  });

  const result_indices = [],
    wordsCount = words.length;
  wordLength = words[0].length;

  for (i = 0; i < (str.length - wordsCount * wordLength) + 1; i++) {
    const wordsSeen = {};
    for (j = 0; j < wordsCount; j++) {
      next_word_index = i + j * wordLength;

      word = str.substring(next_word_index, next_word_index + wordLength);
      if (!(word in wordFrequency)) {
        break;
      }

      if (!(word in wordsSeen)) {
        wordsSeen[word] = 0;
      }
      wordsSeen[word] += 1;

      if (wordsSeen[word] > (wordFrequency[word] || 0)) {
        break;
      }

      if (j + 1 === wordsCount) {
        result_indices.push(i);
      }
    }
  }

  return result_indices;
}
