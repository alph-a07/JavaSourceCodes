package leetcode.editor.en;// 2022-07-15 14:30:22

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution199 {
    // return last element of each level
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        queue.add(root); // add root

        while (!queue.isEmpty()) {
            int prevSize = queue.size();

            // 🎯 prevSize - 1
            for (int j = 0; j < prevSize - 1; j++) {
                TreeNode temp = queue.remove();

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

            // last of level
            TreeNode temp = queue.remove();
            ans.add(temp.val);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
