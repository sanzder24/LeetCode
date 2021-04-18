class Solution {
    public boolean canPartition(int[] nums) {
        int total =0;
        for(int i: nums){
            total += i;
        }
        
        if(total%2!=0){
            return false;
        }
        
        return canPartition( nums, 0, 0, total, new HashMap<String, Boolean>());
    }
    
    public boolean canPartition( int[] nums, int index, int sum, int total, HashMap<String, Boolean> state){
        String current = index + "" + sum;
        if(state.containsKey(current)){
            return state.get(current);
        }
        if(sum *2 == total){
            return true;
        }
        if(index>=nums.length || sum> total/2){
            return false;
        }
        boolean foundPartition = canPartition(nums, index + 1, sum, total, state) 
        || canPartition( nums, index + 1, sum + nums[index], total, state );
            return foundPartition;
    }
}
class Solution2 {
    public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if ((sum & 1) == 1) {
                return false;
            }

            sum /= 2;

            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], false);
            }

            dp[0][0] = true;

            for (int i = 1; i < n + 1; i++) {
                dp[i][0] = true;
            }

            for (int j = 1; j < sum + 1; j++) {
                dp[0][j] = false;
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1]) {
                        dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                    }
                }
            }

            return dp[n][sum];
    }
}