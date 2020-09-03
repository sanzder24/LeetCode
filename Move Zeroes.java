class Solution {
     public void moveZeroes(int[] nums) {
         int right=0, left=0;
         while (right < nums.length) {
                if (nums[right] == 0) {
                   right++;
                }
                else{
                    int temp=nums[left];
                    nums[left]=nums[right];
                    nums[right]=temp;
                    right++;
                    left++;
                }
            }
        }
}