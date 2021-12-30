package stacks;

import linkedlists.LinkedList;

public class StackUsingLinkedList {
    private LinkedList stack;

    public StackUsingLinkedList() {
        this.stack = new LinkedList();
    }

    // To insert an element
    // O(1)
    public void push(int element) {
        this.stack.addAtFirst(element);
    }

    // Removes and returns the upmost element
    // O(1)
    public int pop() throws Exception {
        return this.stack.removeFirst();
    }

    // To see upmost element
    // O(1)
    public int peek() throws Exception {
        return this.stack.getFirst();
    }

    // Prints stack
    // O(N)
    public void show() {
        this.stack.display();
    }

    // Returns size
    // O(1)
    public int size() {
        return this.stack.getSize();
    }

    // Checks wether stack is empty or not
    // O(1)
    public boolean isEmpty() {
        return this.stack.getSize() == 0;
    }
}
