package trees;

// Construct a BST whose inorder traversal in given as an array
public class BinarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;

        private Node() {
        }

        private Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public BinarySearchTree(int[] array) {
        this.root = construct(array, 0, array.length - 1);
    }

    private Node construct(int[] arr, int low, int high) {
        if (low > high)
            return null;
        // mid-element is chosen as root to build a balanced tree
        int mid = (low + high) / 2;

        // generation of tree
        Node node = new Node();
        node.data = arr[mid];
        // Assuming that recursion already works
        // Hence it will generate left and right itself
        node.left = construct(arr, low, mid - 1);
        node.right = construct(arr, mid + 1, high);

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

    public boolean find(int data) {
        return find(data, this.root);
    }

    // Using property of BST
    private boolean find(int data, Node node) {
        if (node == null)
            return false;
        if (data < node.data)
            return find(data, node.left);
        else if (data > node.data)
            return find(data, node.right);
        else
            return true;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        if (node.right == null)
            return node.data;

        return max(node.right);
    }

    public void add(int data) {
        add(data, this.root);
    }

    private void add(int data, Node node) {
        if (data < node.data && node.left == null)
            node.left = new Node(data);
        else if (data > node.data && node.right == null) {
            node.right = new Node(data);
        }

        if (data < node.data)
            add(data, node.left);
        else if (data > node.data)
            add(data, node.right);
    }

    public void remove(int data) {
        remove(data, this.root, null, false);
    }

    private void remove(int data, Node node, Node parent, boolean isLeftChild) {
        // go find in left subtree
        if (data < node.data)
            remove(data, node.left, node, true);
            // go find in right subtree
        else if (data > node.data)
            remove(data, node.right, node, false);
            // data found
        else {
            // case 1 : Node is a leaf Node(left = right = null)
            if (node.left == null && node.right == null) {

                // Unlink the node from its parent according to whether it is right or left child
                if (isLeftChild)
                    parent.left = null;
                else
                    parent.right = null;
            }

            // case 2 : Left child of node is null but right child is not null
            if (node.left == null && node.right != null) {
                // Link the next node to the parent node according to whether current node is right or left child
                if (isLeftChild)
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }

            // case 3 : Left child of node is not null but right child is null
            if (node.right == null && node.left != null) {
                // Link the next node to the parent node according to whether current node is right or left child
                if (isLeftChild)
                    parent.left = node.left;
                else
                    parent.right = node.left;
            }

            // case 4 : Both right and left children are not null
            if (node.left != null && node.right != null) {
                // For a BST all elements on the left should be less than the parent
                // Hence we will find maximum value from left an assign it to the current node
                int max = this.max(node.left);
                node.data = max;

                // And then remove the max node from left subtree
                this.remove(max, node.left, node, true);
            }
        }
    }
}

class test2 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 20, 30, 40, 50, 60, 70};
        BinarySearchTree tree = new BinarySearchTree(array);
        tree.display();
        System.out.println();

        System.out.println(tree.find(20));
        System.out.println(tree.find(80));
        System.out.println();

        System.out.println(tree.max());
        System.out.println();

        tree.add(15);
        tree.display();
        System.out.println();

        tree.remove(40);
        tree.display();
    }
}
