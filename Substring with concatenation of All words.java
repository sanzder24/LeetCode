class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words == null || words.length == 0 || s == null || s.length() == 0){
            return res;
        }
        int wlen = words[0].length();
        int slen = s.length();
        if(wlen > slen){
            return res;
        }
        Map<String, Integer> mp = new HashMap<>();
        for(String word: words){
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        int wcount = words.length;
        for(int i = 0; i < wlen; i++){
            int j = i;
            Map<String, Integer> mpcur = new HashMap<>();
            int countcur = 0;
            int start = i;
            for( ; j <= slen - wlen; j+= wlen){
                String sub = s.substring(j, j + wlen);
                if(mp.get(sub) == null){
                    start = j + wlen;
                    countcur = 0;
                    mpcur.clear();
                    continue;
                } 
                mpcur.put(sub, mpcur.getOrDefault(sub, 0) + 1);
                countcur++; 
                while(mpcur.get(sub) > mp.get(sub)){
                    String startsub = s.substring(start, start + wlen);
                    if(mpcur.get(startsub) == 1){
                        mpcur.remove(startsub);
                    } else {
                        mpcur.put(startsub, mpcur.get(startsub) - 1);
                    }
                    countcur--;
                    start += wlen;
                }
                if(countcur == wcount){
                    res.add(start);
                    String startsub = s.substring(start, start + wlen);
                    if(mpcur.get(startsub) == 1){
                        mpcur.remove(startsub);
                    } else {
                        mpcur.put(startsub, mpcur.get(startsub) - 1);
                    }
                    start += wlen;
                    countcur--;
                }
            }
        }
        return res;
    }
}