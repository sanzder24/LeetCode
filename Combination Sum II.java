class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findcombination(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    public void findcombination( int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if(target<0){
            return;
        }
        for( int i = index; i< candidates.length; i++){
            if( i == index || candidates[i]!=candidates[i-1]){
                current.add(candidates[i]);
                findcombination(candidates, i+1, target - candidates[i], current, result); 
                current.remove(current.size()-1);  //Removing to allow other numbers to parse and find if they form a subset
            }
        }
    }
}