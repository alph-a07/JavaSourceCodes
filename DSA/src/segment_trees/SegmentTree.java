package segment_trees;

public class SegmentTree {
    private static class Node {
        int data;
        int start;
        int end;
        Node left;
        Node right;
    }

    Node root;

    SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        // BASE CASE
        if (start == end) {
            // create leaf node
            Node leafNode = new Node();
            leafNode.data = arr[start];
            leafNode.start = start;
            leafNode.end = end;

            return leafNode;
        }

        // Generate root node
        Node node = new Node();
        node.start = start;
        node.end = end;

        int mid = (start + end) / 2;

        // left and right of root node
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // data of root node
        node.data = node.left.data + node.right.data;

        return node;
    }

    // query = sum
    // O(log N)
    public int getSum(int start, int end) {
        return getSum(this.root, start, end);
    }

    private int getSum(Node node, int start, int end) {

        // node interval completely lies b/w query interval
        // that will contribute to our sum
        if (node.start >= start && node.end <= end) {
            return node.data;
        }

        // node interval and query interval are disjoint
        // no contribution to sum
        else if (node.end < start || node.start > end) {
            return 0;
        }

        // node interval and query interval partially overlap
        // search for answers in left and right children
        else {
            return getSum(node.left, start, end) + getSum(node.right, start, end);
        }
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String string = "";

        // not leaf nodes
        if (node.start != node.end) {
            string += "Interval [" + node.left.start + "," + node.left.end + "] Sum = " + node.left.data +
                    " =>| " + "Interval [" + node.start + "," + node.end + "] Sum = " + node.data + " |<= " +
                    "Interval [" + node.right.start + "," + node.right.end + "] Sum = " + node.right.data;
        }
        // leaf nodes
        else {
            string += "No left child" +
                    " =>| " + "Interval [" + node.start + "," + node.end + "] Sum = " + node.data + " |<= " +
                    "No right child";
        }

        System.out.println(string);

        // recursive calls
        if (node.left != null && node.right != null) {
            display(node.left);
            display(node.right);
        }
    }

    // O(log N)
    public void update(int index, int data) {
        // sum needs to be updated
        this.root.data = update(root, index, data);
    }

    private int update(Node node, int index, int data) {

        // if index lies b/w node's interval
        if (index >= node.start && index <= node.end) {
            // index found
            if (node.start == node.end) {
                // update data
                node.data = data;
            } else {
                // search in children for result
                node.data = update(node.left, index, data) + update(node.right, index, data);
            }
        }
        return node.data;
    }
}

class test {
    public static void main(String[] args) {
        SegmentTree sg = new SegmentTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        sg.display();
        System.out.println(sg.getSum(2, 5));
        sg.update(4, -5);
        System.out.println(sg.getSum(2, 5));
    }
}
