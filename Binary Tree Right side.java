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
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
            while(!que.isEmpty()){
                int size = que.size();
                for( int i=0; i<size; i++){
                    TreeNode current = que.remove();
                    if(i==size-1){
                        result.add(current.val);
                    }
                    if(current.left!=null){
                        que.add(current.left);
                    }
                     if(current.right!=null){
                        que.add(current.right);
                    }
                }
            }
        return result;
    
    }
}