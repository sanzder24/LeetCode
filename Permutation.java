class Solution {
    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            result.add(new ArrayList<>());
            return backtracking(nums, 0, result);
        }

        private List<List<Integer>> backtracking(int[] nums, int index, List<List<Integer>> result) {
            if (index == nums.length) {
                return result;
            }
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> eachList : result) {
                for (int i = 0; i <= eachList.size(); i++) {
                    List<Integer> newList = new ArrayList<>(eachList);
                    newList.add(i, nums[index]); //places the number in all possible places ->
                    
                    newResult.add(newList);
                }
            }
            result = newResult;
            System.out.println(result);
            return backtracking(nums, index + 1, result);
        }
}
/*
System.out.println(result)
[[1]]
[[2, 1], [1, 2]
[[3, 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2], [1, 2, 3]] */