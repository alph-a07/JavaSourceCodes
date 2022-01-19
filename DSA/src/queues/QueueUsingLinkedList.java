package queues;

import linkedlists.LinkedList;

// DYNAMIC QUEUE
public class QueueUsingLinkedList {
    private LinkedList queue;

    public QueueUsingLinkedList() {
        queue = new LinkedList();
    }

    // O(1)
    public int size(){
        return this.queue.getSize();
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(1)
    public void enqueue(int data) {
        queue.addAtLast(data);
    }

    // O(1)
    public int dequeue() throws Exception {
        return queue.removeFirst();
    }

    // O(1)
    public int getFront() throws Exception {
        return queue.getFirst();
    }

    // O(N)
    public void display(){
        this.queue.display();
    }
}
