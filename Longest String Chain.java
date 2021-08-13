class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<String>[] wordList = new List[17];
        for (String word : words){
            int len = word.length();
            if (wordList[len] == null){
                wordList[len] = new ArrayList<>();
            }
            wordList[len].add(word);
            map.put(word, 1);
        }
        int max = 1;
            
        for (int len = 1; len < 17; len++){
            if (wordList[len] == null){
                continue;
            }
            for (String word : wordList[len]){
                int preLen = len - 1;
                if (wordList[preLen] == null){
                    break;
                }
                for (String preWord : wordList[preLen]){
                    if (isPre(preWord, word)){
                        map.put(word, Math.max(map.get(word), map.get(preWord) + 1));
                        max = Math.max(max, map.get(word));
                    }
                }
            }
        }
        
        return max;
    }
    
    private boolean isPre(String preWord, String curWord){
        int p1 = 0, p2 = 0;
        boolean found = false; // one can be inserted so 1 false allowed
        while (p1 < preWord.length() && p2 < curWord.length()){
            if (preWord.charAt(p1) == curWord.charAt(p2)){
                p1++;
                p2++;
            } else if (found){
                return false;
            } else {
                p2++;
                found = true;
            }
        }
        return true;
    }
}