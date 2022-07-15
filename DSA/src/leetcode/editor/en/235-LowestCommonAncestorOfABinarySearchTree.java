package leetcode.editor.en;// 2022-07-13 15:35:41

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // different side
        if (p.val < root.val && q.val > root.val)
            return root;

        // left side
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        // right side
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
