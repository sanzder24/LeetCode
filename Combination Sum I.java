class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if(candidates[i]>target){
                continue;
                }           
                current.add(candidates[i]);
                findcombination(candidates, i, target - candidates[i], current, result); 
                current.remove(current.size()-1); 
        }
      }   
    }
