/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
    Stack<TreeNode> root_stack = new Stack<>();
    Stack<Integer> val_stack = new Stack<>();
        root_stack.add(root);
        val_stack.add(targetSum -root.val);
        while(!root_stack.isEmpty()){
            TreeNode current = root_stack.pop();
            int current_sum = val_stack.pop();
            if(current.left == null && current.right ==null && current_sum==0){
                return true;
            }
            if(current.left!=null){
                root_stack.add(current.left);
                val_stack.add(current_sum-current.left.val);
            }
            if(current.right!=null){
                root_stack.add(current.right);
                val_stack.add(current_sum-current.right.val);
            }
        }
        return false;
    }
}/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
    Stack<TreeNode> root_stack = new Stack<>();
    Stack<Integer> val_stack = new Stack<>();
        root_stack.add(root);
        val_stack.add(targetSum -root.val);
        while(!root_stack.isEmpty()){
            TreeNode current = root_stack.pop();
            int current_sum = val_stack.pop();
            if(current.left == null && current.right ==null && current_sum==0){
                return true;
            }
            if(current.left!=null){
                root_stack.add(current.left);
                val_stack.add(current_sum-current.left.val);
            }
            if(current.right!=null){
                root_stack.add(current.right);
                val_stack.add(current_sum-current.right.val);
            }
        }
        return false;
    }
}

public static class Solution2 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }