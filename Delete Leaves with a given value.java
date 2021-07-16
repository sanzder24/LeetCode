class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // using the post order traversal as root will be evaluated after the evaluation of it's children
        traverse(root, target);
        // check for the root that is only node
        if (root.val==target && root.left==null && root.right==null)return null;
        
        return root;
    }
    // post order traversal
        public void traverse(TreeNode node, int target){
            if (node!=null){
                traverse(node.left, target);
                traverse(node.right, target);
                
                // check left child
                if (node.left!=null){
                    // now check the value and then check for it's leaf node possibility
                    if (node.left.val==target && node.left.left==null && node.left.right==null){
                        node.left=null;
                    }
                }
                
                // check the righht child
                if (node.right!=null){
                    if (node.right.val==target && node.right.left==null && node.right.right==null){
                        node.right=null;
                    }
                }
            }
        }
}