package leetcode.editor.en;// 2022-05-09 01:29:47

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// left root right
class Solution94 {
    // LEFT ROOT RIGHT
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {
            // go to left till end
            if (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            // all left pushed to stack
            else {
                TreeNode temp = stack.pop(); // pop (bottom most left)
                ans.add(temp.val); // ADD LEFT FIRST
                pointer = temp.right; // move to right node
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
