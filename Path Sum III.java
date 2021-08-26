class Solution {
   	public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSumRootToNode(root, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumRootToNode(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val - targetSum == 0) {
            result++;
        }
        if (root.left != null) {
            result = result + pathSumRootToNode(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            result = result + pathSumRootToNode(root.right, targetSum - root.val);
        }
        return result;
    }
}

class Solution {
    int count = 0;
    int tar;
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        this.tar = targetSum;
        dfs(root, 0);
        return count;
    }
    
    public void dfs(TreeNode root, int curSum) {
        curSum += root.val;
        if(curSum == tar)
            count++;
        count += map.getOrDefault(curSum - tar, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        if(root.left != null)
            dfs(root.left, curSum);
        if(root.right != null)
            dfs(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
}