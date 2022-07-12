package leetcode.editor.en;// 2022-07-05 16:25:34

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
class Solution144 {
    // ROOT LEFT RIGHT
    public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {
            // push all left nodes to stack
            if (pointer != null) {
                stack.push(pointer);
                ans.add(pointer.val); // ADD ROOT FIRST
                pointer = pointer.left; // move left
            }
            // all left pushed to stack
            else {
                TreeNode temp = stack.pop();
                pointer = temp.right; // move to right
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
