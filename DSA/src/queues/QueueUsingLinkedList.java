package queues;

import java.util.LinkedList;

public class QueueUsingLinkedList {
    private LinkedList<Integer> queue;

    public QueueUsingLinkedList() {
        queue = new LinkedList<>();
    }

    // O(1)
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // O(1)
    public void enqueue(int data) {
        queue.addFirst(data);
    }

    // O(1)
    public void dequeue() {
        queue.removeFirst();
    }

    // O(1)
    public int getFront() {
        return queue.getFirst();
    }
}
