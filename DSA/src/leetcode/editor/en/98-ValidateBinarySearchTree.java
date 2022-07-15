package leetcode.editor.en;// 2022-07-13 14:39:51

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
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Approach - check if any node fails to follow property of a BST
    private boolean isBST(TreeNode node, long minValue, long maxValue) {
        // reached and without failing
        if (node == null)
            return true;

        // if current node does not follow property of BST
        if (node.val <= minValue || node.val >= maxValue)
            return false;

            // if left subtree does not follow property of BST
        else if (!isBST(node.left, minValue, node.val))
            return false;

            // if right subtree does not follow property of BST
        else if (!isBST(node.right, node.val, maxValue))
            return false;

        // no failing detected
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
