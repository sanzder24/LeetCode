/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: return a boolean
     */
    public boolean checkEqualTree(TreeNode root){
		Map<TreeNode, Integer> map = new HashMap<>();
		int totalsum = findsum(root, map);
		if(totalsum%2!=0 || map.size()<2){
			return false;
		}
        for(TreeNode key: map.keySet()){
            if(map.get(key)==totalsum/2)
            return true;
        }
        return false;

	}
	public int findsum(TreeNode root, Map<TreeNode, Integer> map){
		if(root==null){
			return 0;
		}
		if( root.left == null && root.right == null){
			map.put(root, root.val);
			return root.val;
		}
		int leftval = 0;
		if(root.left!=null){
			leftval = findsum(root.left, map);
		}
		int rightval = 0;
		if(root.right!=null){
			rightval = findsum(root.right, map);
		}
		int sum = leftval + rightval + root.val;
		map.put(root, sum);
		return sum;
	}
}