package leetcode.editor.en;// 2022-07-06 15:59:01

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
class Solution145 {
    // LEFT RIGHT ROOT
    // Opposite approach to pre-order
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {
            if (pointer != null) {
                stack.push(pointer);
                ans.addFirst(pointer.val); // add to ans from opposite side
                pointer = pointer.right; // opposite to pre-order
            } else {
                TreeNode temp = stack.pop();
                pointer = temp.left; // opposite to pre-order
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
