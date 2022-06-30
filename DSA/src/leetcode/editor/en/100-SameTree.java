package leetcode.editor.en;// 2022-05-09 01:31:43

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
class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null => same
        if (p == null && q == null)
            return true;

        // only one null => not same
        if (p == null || q == null)
            return false;

        // if current node value is same check further
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
