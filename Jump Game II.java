class Solution {
    public int jump(int[] nums) {
        int longJump = 0, jump =0, currentJump =0;
        for(int i=0; i<nums.length-1; i++){
            longJump= Math.max(longJump, i + nums[i]);
            
            if(i == currentJump){
             jump++;
             currentJump = longJump;
            }
        }
        return jump;
    }
}