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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        HashSet<Integer> delete = new HashSet<>();
        for( int i: to_delete){
            delete.add(i);
        }
        removenodes(root, delete, result);
        if(!delete.contains(root.val)){
            result.add(root);
        }
        return result;
    }
    public TreeNode removenodes( TreeNode root, Set<Integer> delete,List<TreeNode> result){
        
        if(root ==null){
            return null;
        }
        root.left = removenodes(root.left, delete, result);    // store null while recurseing and adding children
        root.right = removenodes(root.right, delete, result); 
        if(delete.contains(root.val)){
            if(root.left!=null){            //check for end or changed value
                result.add(root.left);
            }
            if(root.right!=null){
                result.add(root.right);
            }
        return null;  //To replace value in root.left or root.right during recursion 
        }
        return root;
    }
        
}