public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);  //local traverse high value check
                }									
            }
            dp[i] = maxval + 1;     // and add if applies from previous to + 1 
            maxans = Math.max(maxans, dp[i]); //final ans comparision 
        }
        return maxans;
    }
}