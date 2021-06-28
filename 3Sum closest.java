class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff= Integer.MAX_VALUE, n = nums.length;
        for(int i=0; i<n && diff!=0; i++){
            int low= i+1, high = n-1;
            while(low<high){
                int sum = nums[i] + nums[low]+ nums[high];
                if(Math.abs(target-sum)<Math.abs(diff)){
                    diff = target-sum;
                }
                if(sum<target){
                    low++;
                }
                else high--;
            }
        }
        return target-diff;
    }
}