package leetcode.editor.en;// 2022-07-16 15:50:22

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

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
    public TreeNode bstFromPreorder(int[] preorder) {
        Arrays.sort(preorder);

        return returnSubTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode returnSubTree(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = returnSubTree(nums, low, mid - 1);
        root.right = returnSubTree(nums, mid + 1, high);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
