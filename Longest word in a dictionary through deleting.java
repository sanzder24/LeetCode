class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
     Collections.sort(dictionary, (a, b) -> a.length() == b.length() ? a.compareTo(b):b.length()-a.length());
            for (String dictWord : dictionary) {
                int i = 0;
                for (char c : s.toCharArray()) {
                    if (i < dictWord.length() && dictWord.charAt(i) == c) {
                        i++;
                    }
                }
                if (i == dictWord.length()) {
                    return dictWord;
                }
            }
            return "";   
    }
}