package leetcode.editor.en;// 2022-07-12 17:28:53

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
/*class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}*/

class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorder(ans, root);
        return ans;
    }

    private void preorder(List<Integer> ans, Node root) {
        if (root == null || root.children == null)
            return;

        ans.add(root.val); // root
        for (Node child : root.children)
            preorder(ans, child); // children
    }
}
//leetcode submit region end(Prohibit modification and deletion)
