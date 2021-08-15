class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c : s.toCharArray())
            map[c] = 0;
        for(char c : t.toCharArray()){
            map[c]++;
        }
        int end = 0; int start = 0; int minLen = Integer.MAX_VALUE; int minStart = 0;
        int count = t.length();
        while(end < s.length()){
            char ec= s.charAt(end);
            if(map[ec] > 0) count--;
            map[ec]--; //reduce all value as needed 
            while(count == 0){
                if(minLen > end - start){
                minLen = end - start;
                minStart = start;
                }
                char sc = s.charAt(start);
                map[sc]++;
                if(map[sc] > 0) count++; //handles all duplicate value in STRING 't' with line 21 
                start++;
            }
            end++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(minStart, minStart + minLen + 1);
    }
}