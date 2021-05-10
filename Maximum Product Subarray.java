class Solution {
    public int maxProduct(int[] nums) {
           int min = nums[0];
           int max = nums[0];
            int result =nums[0];
            for (int i = 1; i < nums.length; i++) {
               int temp_max = Math.max(nums[i] * max, Math.max(nums[i] * min, nums[i])); //track maximum subarray
                        min = Math.min(nums[i] * max, Math.min(nums[i] * min, nums[i])); //track minimum subarray
                max = temp_max;
                result = Math.max(result, max);
            }
            return result;
        }
} 