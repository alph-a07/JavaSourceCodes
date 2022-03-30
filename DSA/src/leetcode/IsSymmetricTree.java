package leetcode;

public class IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        while (true) {
            if (left==null && right == null)
                return true;

            if (left ==null || right==null)
                return false;

            if (left.val == right.val){
                left = left.left;
                right = right.right;
            }
        }
    }
}
