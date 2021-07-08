class CharacterReplacement {
  public static int findLength(String str, int k) {
    int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
    Map<Character, Integer> letterFrequencyMap = new HashMap<>();
    // try to extend the range [ws, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
      maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

      if (windowEnd - ws + 1 - maxRepeatLetterCount > k) { //substracting repeating characters to find max window
        char leftChar = str.charAt(ws);
        letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
        ws++;
      }

      maxLength = Math.max(maxLength, windowEnd - ws + 1);
    }

    return maxLength;ws
  }

  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }
}

T: O(N)
S: O(26) - O(1)