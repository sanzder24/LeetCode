class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> out_arr = new ArrayList<>();
        
        if( root == null){
        return out_arr;
        }
        TreeNode current = root;
        
        while(current!=null || !stack.isEmpty()) {
            while(current!=null){
                stack.push(current);
                current= current.left;
            }
            current = stack.pop();
            out_arr.add(current.val);
            current = current.right;
        }
        return out_arr;
        
    }
}