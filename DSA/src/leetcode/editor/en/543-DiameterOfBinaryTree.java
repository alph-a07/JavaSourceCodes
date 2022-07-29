package leetcode.editor.en;// 2022-07-30 03:25:57

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
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return leftHeight + rightHeight;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
