 ###Slinding Window
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int[] count = new int[256];
            int left = 0;
            int result = 0;
            int num = 0;
            for (int right = 0; right < s.length(); right++) {
                if (count[s.charAt(right)]++ == 0) { //++ will update count regardless
                    num++; //distinct vlaue check 
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

        sol 2 {
                public int lengthOfLongestSubstringKDistinct(String s, int k) {
                
                if(s==null || s.length() == 0){
                    return 0;
                }
                int map = new int[256];
                int l=0, r=0, distinct =0; max=0;

                for( ;r<s.length();r++){
                    if(map[s.charAt(r)==0])distinct++;
                    map[s.charAt(r)]++;
                    while(distinct>k){
                    map[s.charAt(l)]--;
                    if(map[s.charAt(l)]==0)distinct --;
                    l++;
                }
                max = Math.max(max, r-l+1); 
                }

                }
        }