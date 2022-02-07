package linkedlists;

import linkedlists.LinkedList;

public class GenericLinkedList<T> {

    // Defining Node of a Linked List
    // No outside access(INNER and PRIVATE)
    private class Node {
        T data;
        Node next;
    }

    // Summary Objects of Linked List class
    private Node head;
    private Node tail;

    public int getSize() {
        return size;
    }

    private int size;

    // O(N)
    public void display() {
        Node temp = head;
        while (temp != null)
        // tail.next = null
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // O(1)
    public void addAtLast(T data) {
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

    // O(1)
    public void addAtFirst(T data) {
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

    // O(1)
    public T getLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is empty.");
        }
        return this.tail.data;
    }

    // O(1)
    public T getFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is empty.");
        }
        return this.head.data;
    }

    // O(N)
    public T getAt(int index) throws Exception {
        if (this.size == 0 || index >= this.size || index < 0) {
            throw new Exception("Invalid Index.");
        }
        Node temp = head;

        for (int i = 0; i < index; i++) {
            // Move temp till desired index
            temp = temp.next;
        }
        return temp.data;
    }

    // O(N)
    private Node getNodeAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }

        if (index >= this.size || index < 0) {
            throw new Exception("Invalid Index.");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            // Move temp till desired index
            temp = temp.next;
        }
        return temp;
    }

    // O(1)
    public T removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }
        T removedData = this.head.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            head = head.next;
            this.size--;
        }
        return removedData;
    }

    // O(N)                                                     -- As getNodeAt is used
    public T removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }
        T removedData = this.tail.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            Node n = getNodeAt(this.size - 2);
            tail = n;
            tail.next = null;
            this.size--;
        }
        return removedData;
    }

    // O(N)
    public T removeAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }

        if (index >= this.size || index < 0) {
            throw new Exception("Invalid Index.");
        }

        T removedData = getAt(index);
        if (index == 0) {
            removeFirst();
        } else if (index == this.size - 1) {
            removeLast();
        } else {
            getNodeAt(index - 1).next = getNodeAt(index - 1).next.next;
            size--;
        }
        return removedData;
    }

    // O(N)
    public int getIndex(T data){
        int index = 0;
        for (Node temp = head;temp!=null;temp=temp.next){
            if (temp.data.equals(data))
                return index;

            index++;
        }

        return -1;
    }
}
