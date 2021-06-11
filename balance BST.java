class Solution {
     public TreeNode balanceBST(TreeNode root) {
            List<Integer> inorder = inorder(root, new ArrayList<>());
         for(int i =0; i<inorder.size(); i++){
            System.out.println(inorder.get(i));
         }
            
            return dfs(inorder, 0, inorder.size() - 1);
        }

        private List<Integer> inorder(TreeNode root, List<Integer> list) {     //Use inorder to get the list populated 
            if (root == null) {
                return list;
            }
            inorder(root.left, list);
            list.add(root.val);
            return inorder(root.right, list);
        }

        private TreeNode dfs(List<Integer> nums, int start, int end) { // convert sorted array to BST
            if (end < start) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums.get(mid));
            root.left = dfs(nums, start, mid - 1);
            root.right = dfs(nums, mid + 1, end);
            return root;
        }
}