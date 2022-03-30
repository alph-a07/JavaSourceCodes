package trees;

import java.util.*;

// Any Node can have at max 2 children
public class BinaryTree {
    private static class Node {
        int data;
        Node left;  // left child of current node
        Node right; // right child of current node

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    BinaryTree() {
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s, null, false);
    }

    // isLeftOrRight -> states whether the current node is left or right child of its parent(if exists)
    // left => TRUE ; right = FALSE ; no parent = FALSE
    public Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
        if (parent == null) {
            System.out.print("Enter the data for the root node : ");
        } else {
            if (isLeftOrRight) {
                System.out.print("Enter the data for left child of " + parent.data + " : ");
            } else {
                System.out.print("Enter the data for right child of " + parent.data + " : ");
            }
        }

        int nodeData = s.nextInt();
        // children will be added later exclusively
        Node node = new Node(nodeData, null, null);
        this.size++;

        // asking for left child
        System.out.print("Do you want left child of " + node.data + " (Y/N) : ");
        String s1 = s.next();
        if (Objects.equals(s1, "Y") || Objects.equals(s1, "y")) {
            node.left = takeInput(s, node, true);
        }

        // asking for right child
        System.out.print("Do you want right child of " + node.data + " (Y/N) : ");
        String s2 = s.next();
        if (Objects.equals(s2, "Y") || Objects.equals(s2, "y")) {
            node.right = takeInput(s, node, false);
        }
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String string = "" + node.data;
        if (node.left != null) {
            string = node.left.data + " => " + string;
        } else {
            string = "null => " + string;
        }

        if (node.right != null) {
            string = string + " <= " + node.right.data;
        } else {
            string = string + " <= null";
        }
        System.out.println(string);

        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        // base case
        // reached end
        if (node == null) {
            // REASON FOR RETURNING -1 BUT NOT 0
            // it can be understood via example of a tree which has only one node(i.e. root)
            // if 0 was returned then the tree height will be 0 + 1 = 1
            return -1;
        }
        // We will get heights of left subtree and right subtree using recursion
        // And then add 1 to maximum of both and return it as the height of tree

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void preOrder() {
        preOrder(this.root);
    }

    // root left right
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    // left right root
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.data + " ");
    }

    public void inOrder() {
        inOrder(this.root);
    }

    // left root right
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void iterativeInorder() {
        System.out.println(iterativeInorder(this.root));
    }

    // left root right
    private ArrayList<Integer> iterativeInorder(Node node) {
        // empty tree
        if (node == null)
            return new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            // if current node is not null then push it to stack
            // go to its left node
            if (node != null) {
                stack.push(node);
                node = node.left;
            }

            // if the current node is null i.e. reached end
            else {
                // if reached end stack is also empty then all elements are added
                // break the loop
                if (stack.isEmpty())
                    break;

                // go to stack and add the element as it will be last left element
                node = stack.pop();
                list.add(node.data);
                // go to right node
                node = node.right;
            }
        }
        return list;
    }

    // level wise
    public void levelOrder() {
        LinkedList<Node> l = new LinkedList<>();
        l.add(this.root);
        // Add one node
        // Remove it and print its data
        // Print its left and right if exists
        while (!l.isEmpty()) {
            Node temp = l.removeFirst();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                l.add(temp.left);
            if (temp.right != null)
                l.add(temp.right);
        }
    }

    public boolean isBST() {
        // root can have any value
        // while left node should be less than current node and right node should be greater than current node
        return isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Approach - check if any node fails to follow property of a BST
    private boolean isBST(Node node, int minValue, int maxValue) {
        // reached and without failing
        if (node == null)
            return true;

        // if current node does not follow property of BST
        if (node.data < minValue || node.data > maxValue)
            return false;

            // if left subtree does not follow property of BST
        else if (!isBST(node.left, minValue, node.data))
            return false;

            // if right subtree does not follow property of BST
        else if (!isBST(node.right, node.data, maxValue))
            return false;

        // no failing detected
        return true;
    }

    public int sumOfLeaves() {
        return sumOfLeaves(this.root);
    }

    private int sumOfLeaves(Node node) {
        int sum = 0;
        if (node.right == null && node.left == null)
            sum += node.data;

        if (node.left != null)
            sum += sumOfLeaves(node.left);

        if (node.right != null)
            sum += sumOfLeaves(node.right);

        return sum;
    }

    public int diameter() {
        return diameter(this.root);
    }

    // Height function is used multiple times for performing same operations
    // TIME COMPLEXITY = O(N^2)
    private int diameter(Node node) {
        // base case
        if (node == null)
            return 0;
        // when diameter passes through the root from left subtree to right subtree
        int case1 = this.height(node.left) + this.height(node.right) + 2;
        // when diameter lies within the left subtree
        int case2 = this.diameter(node.left);
        // when diameter lies within the right subtree
        int case3 = this.diameter(node.right);

        return Math.max(case1, Math.max(case2, case3));
    }

    public int optimizedDiameter() {
        return this.optimizedDiameter(this.root).diameter;
    }

    // Same concept different approach
    // TIME COMPLEXITY = O(N)
    private Pair optimizedDiameter(Node node) {
        if (node == null) {
            return new Pair(-1, 0);
        }

        Pair left = optimizedDiameter(node.left);
        Pair right = optimizedDiameter(node.right);

        Pair temp = new Pair();

        temp.height = Math.max(left.height, right.height) + 1;
        temp.diameter = Math.max((left.height + right.height + 2), Math.max(left.diameter, right.diameter));

        return temp;
    }

    private static class Pair {
        int height;
        int diameter;

        Pair() {
        }

        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}

class test1 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.display();
        System.out.println();

        System.out.println("Tree Height : " + tree.height());
        System.out.println();

        System.out.println("Pre-Order");
        tree.preOrder();
        System.out.println();

        System.out.println("Post-Order");
        tree.postOrder();
        System.out.println();

        System.out.println("In-Order");
        tree.inOrder();
        System.out.println();

        System.out.println("Level Order");
        tree.levelOrder();
        System.out.println();

        System.out.println("In-Order");
        tree.iterativeInorder();
        System.out.println();

        System.out.println("Sum of leaves");
        System.out.println(tree.sumOfLeaves());
        System.out.println();

        System.out.println("Diameter");
        System.out.println(tree.diameter());
        System.out.println(tree.optimizedDiameter());
        System.out.println();
    }
}
