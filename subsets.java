class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        generatesubsets(nums, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    public void generatesubsets( int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(current));
        for(int i =index; i<nums.length; i++ ){
            current.add(nums[i]);
            generatesubsets(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
} 

//Time 2^n
//Space o(n)