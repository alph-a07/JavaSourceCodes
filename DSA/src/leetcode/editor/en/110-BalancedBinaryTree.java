package leetcode.editor.en;// 2022-07-16 15:19:32

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
