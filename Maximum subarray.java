class Solution {
    public int maxSubArray(int[] nums) {
            int maxSoFar = nums[0];
            int maxEndingHere = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
            return maxSoFar;
        }
}

[-2,1,-3,4,-1,2,1,-5,4]
num[i] :1
Max End:1
Max Sofar:1
num[i] :-3
Max End:-2
Max Sofar:1
num[i] :4
Max End:4
Max Sofar:4
num[i] :-1
Max End:3
Max Sofar:4
num[i] :2
Max End:5
Max Sofar:5
num[i] :1
Max End:6
Max Sofar:6
num[i] :-5
Max End:1
Max Sofar:6
num[i] :4
Max End:5
Max Sofar:6