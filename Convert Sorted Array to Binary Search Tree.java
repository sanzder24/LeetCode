
class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
            return dfs(num, 0, num.length - 1);
        }

        public TreeNode dfs(int[] num, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (end + start) / 2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = dfs(num, start, mid - 1);
            root.right = dfs(num, mid + 1, end);
            return root;
        }
}