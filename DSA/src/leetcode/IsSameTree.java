package leetcode;

public class IsSameTree {
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
