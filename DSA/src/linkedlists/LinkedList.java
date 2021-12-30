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
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // O(1)
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

    // O(1)
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

    // O(1)
    public int getLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is empty.");
        }
        return this.tail.data;
    }

    // O(1)
    public int getFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is empty.");
        }
        return this.head.data;
    }

    // O(N)
    public int getAt(int index) throws Exception {
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
    public int removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }
        int removedData = this.head.data;
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
    public int removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }
        int removedData = this.tail.data;
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
    public int removeAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("Empty Linked List");
        }

        if (index >= this.size || index < 0) {
            throw new Exception("Invalid Index.");
        }

        int removedData = getAt(index);
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
    public void reverseData() throws Exception {
        int left = 0;
        int right = this.size - 1;

        while (left < right) {
            Node leftNode = getNodeAt(left);
            Node rightNode = getNodeAt(right);

            int temp = leftNode.data;
            leftNode.data = rightNode.data;
            rightNode.data = temp;

            left++;
            right--;
        }
    }

    // O(N)
    public void reversePointers() {
        Node previous = this.head;
        Node current = previous.next;

        while (current != null) {
            // storing next node of current before modifying it
            Node ahead = current.next;
            // reversing two adjacent nodes
            current.next = previous;

            // moving forward
            previous = current;
            current = ahead;
        }

        // finally, swapping head and tail
        Node temp = head;
        head = tail;
        tail = temp;

        tail.next = null;
    }

    // without the use of size attribute
    // O(N)                                                     -- As the function works only till one traverse of fast
    public int midData() {
        Node slow = head;
        Node fast = head;

        // Until fast reaches tail or can't go further
        while (fast.next != null && fast.next.next != null) {
            // slow traverses at half frequency that of fast
            // hence when fast is at tail slow will be at midpoint
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}

class test {
    public static void main(String[] args) throws Exception {
        LinkedList l = new LinkedList();

        l.addAtFirst(1);
        l.addAtLast(2);
        l.addAtLast(3);
        l.addAtLast(4);

        System.out.println(l.midData());
    }
}
