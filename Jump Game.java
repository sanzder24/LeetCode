public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furtherjump=Math.min(position + nums[position],nums.length-1);
        for( int nextposition=furtherjump; nextposition>position;nextposition--){
            if(canJumpFromPosition(nextposition, nums)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}