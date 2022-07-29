package leetcode.editor.en;// 2022-07-30 01:34:56

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
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        // as minimum depth = distance to nearest "leaf node"
        if (leftHeight == 0) return rightHeight + 1;
        if (rightHeight == 0) return leftHeight + 1;

        return Math.min(leftHeight, rightHeight) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
