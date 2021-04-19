public class Solution {

        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int max = 0;
            int[] index = new int[128];
            for (int i = 0, j = 0; j < s.length(); j++) {
                i = Math.max(index[s.charAt(j)], i);  //Take value of the 'character' -> which is the position as it occurs 
                max = Math.max(max, j - i + 1);  //Subtract the position to get new unique substring with starting with that character
                index[s.charAt(j)] = j + 1; //increment with j and so we can new length of unique in prev step
            }
            return max;
        }
    }