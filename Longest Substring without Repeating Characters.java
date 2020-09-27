public class Solution {

        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int max = 0;
            int[] index = new int[128];
            for (int i = 0, j = 0; j < s.length(); j++) {
                i = Math.max(index[s.charAt(j)], i);
                max = Math.max(max, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return max;
        }
    }