136. Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1

My Solution:
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length;i++){
          if(j<nums.length){
              if(nums[i]==nums[j] )
            {
                i++;
                j++;j++;
           }
            else if(nums[i]!=nums[j] ){
                return nums[i];
            }
          }
            
            else return nums[i];
      }
        return 0;
 }
}
