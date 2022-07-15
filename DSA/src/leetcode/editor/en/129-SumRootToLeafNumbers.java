package leetcode.editor.en;// 2022-07-15 15:55:33

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
class Solution129 {
    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum;
    }

    public void helper(TreeNode root, int tempSum) {
        if (root == null)
            return;

        tempSum = tempSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            totalSum += tempSum;
            return;
        }

        helper(root.left, tempSum);
        helper(root.right, tempSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
