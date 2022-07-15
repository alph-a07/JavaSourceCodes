package leetcode.editor.en;// 2022-07-15 17:56:22

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        queue.add(root);

        int currLevel = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int prevSize = queue.size();

            for (int i = 0; i < prevSize; i++) {

                // even level - left to right
                if (currLevel % 2 == 0) {
                    TreeNode temp = queue.removeFirst();

                    level.add(temp.val);

                    // LEFT -> RIGHT
                    if (temp.left != null)
                        queue.addLast(temp.left);
                    if (temp.right != null)
                        queue.addLast(temp.right);
                }
                // odd level - right to left
                else {
                    TreeNode temp = queue.removeLast();

                    level.add(temp.val);

                    // RIGHT -> LEFT
                    if (temp.right != null)
                        queue.addFirst(temp.right);
                    if (temp.left != null)
                        queue.addFirst(temp.left);
                }
            }
            ans.add(level);
            currLevel++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
