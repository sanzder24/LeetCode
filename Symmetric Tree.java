class Solution{
	public boolean isSymmetric(TreeNode root){
		if(root==null)
		return true;
	return isSymmetric(root.left, root.right);
		}

	private boolean isSymmetric(TreeNode Left, TreeNode right){

	if(left == null || right ==null){
		return left == right;
	}
	if(left.val!=right.val){
	return false;
	}
	return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	}