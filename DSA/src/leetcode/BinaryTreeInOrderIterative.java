package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class BinaryTreeInOrderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        // empty tree
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            // if current node is not null then push it to stack
            // go to its left node
            if (root != null) {
                stack.push(root);
                root = root.left;
            }

            // if the current node is null i.e. reached end
            else {
                // if reached end stack is also empty then all elements are added
                // break the loop
                if (stack.isEmpty())
                    break;

                // go to stack and add the element as it will be last left element
                root = stack.pop();
                list.add(root.val);
                // go to right node
                root = root.right;
            }
        }
        return list;
    }
}
