package linkedlists;

public class LinkedList {

    // No outside access(INNER and PRIVATE)
    private class Node {
        int data;
        Node next;
    }

    // Summary Objects of Linked List class
    private Node head;
    private Node tail;
    private int size;

    public void display() {
        Node temp = head;
        while (temp != null)
        // tail.next = null
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void addAtLast(int data) {
        // New Node for new element
        Node nn = new Node();
        nn.data = data;
        // addAtLast means no next element
        nn.next = null;

        // Adding in an empty Linked List
        if (size == 0) {
            // Make new node HEAD
            head = nn;
        }
        // Non-empty Linked List
        else {
            // Attach new node to Linked List
            tail.next = nn;
        }
        // Update tail and size
        tail = nn;
        size++;
    }

    public void addAtFirst(int data) {
        // New Node for new element
        Node nn = new Node();
        nn.data = data;

        // Adding in an empty Linked List
        if (size == 0) {
            // Make new node TAIL
            tail = nn;
        }
        // Non-empty Linked List
        else {
            // Attach new node to Linked List
            nn.next = head;
        }
        // Update head and size
        head = nn;
        size++;
    }
}
