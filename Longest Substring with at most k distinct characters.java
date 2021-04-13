  public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int[] count = new int[256];
            int left = 0;
            int result = 0;
            int num = 0;
            for (int right = 0; right < s.length(); right++) {
                if (count[s.charAt(right)]++ == 0) {
                    num++;
                }
                if (num > k) {
                    while (--count[s.charAt(left++)] > 0) {
                    }
                    ;
                    num--;
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
        }