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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        inorder(root, k, res);
        return res[1];
    }
    public void inorder( TreeNode root, int k, int[] res){
        if(root ==null){
            return;
        }
        inorder(root.left, k, res);
        res[0] += 1; // far left is the lowest and right then mid
        if(res[0] == k){
            res[1] = root.val;
            return;
        }
        inorder(root.right, k, res); // same as above comment
    }
}