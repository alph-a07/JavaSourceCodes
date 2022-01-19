package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

    // Defining Node of a tree
    private class Node {
        int data;
        // Arraylist of all children of Node
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    private Node root;
    private int size;

    GenericTree() {
        Scanner s = new Scanner(System.in);
        // As root does not have any parent (parent = null and ithchild = 0)
        this.root = takeInput(s, null, 0);
    }

    // ithchild => which numbered child is the node(of its parent)
    // i.e. index of the node in the "children arraylist" of the parent
    private Node takeInput(Scanner s, Node parent, int ithchild) {

        if (parent == null) {
            // when tree is empty initially
            System.out.print("Enter the data for root Node : ");
        } else {
            System.out.print("Enter the data for " + ithchild + "th child of " + parent.data + " : ");
        }

        int nodeData = s.nextInt();
        // Parent Node
        Node node = new Node(nodeData);
        this.size++;

        System.out.print("Enter the number of children for " + node.data + " : ");

        int noOfChildren = s.nextInt();

        for (int i = 0; i < noOfChildren; i++) {
            // Children
            // The data will be asked from else statement
            Node child = this.takeInput(s, node, i);
            // Storing children of parent in its arraylist
            node.children.add(child);
        }
        // Node created and returned with its children
        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        StringBuilder string = new StringBuilder(node.data + " => ");
        for (int i = 0; i < node.children.size(); i++) {
            string.append(node.children.get(i).data).append(" ,");
        }
        string.append("END");
        System.out.println(string);
        for (int i = 0; i < node.children.size(); i++) {
            display(node.children.get(i));
        }
    }
}

class test {
    public static void main(String[] args) {
        GenericTree tree = new GenericTree();
        tree.display();
    }
}
