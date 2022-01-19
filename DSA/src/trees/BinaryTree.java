package trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

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
    }
}
