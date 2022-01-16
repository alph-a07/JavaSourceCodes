package stacks;

import queues.QueueUsingLinkedList;

public class StackUsingQueue_PopEfficient {
    private QueueUsingLinkedList q1 = new QueueUsingLinkedList();
    private QueueUsingLinkedList q2 = new QueueUsingLinkedList();

    // O(N)
    public void push(int data) throws Exception {
        q2.enqueue(data);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        QueueUsingLinkedList q;
        q = q1;
        q1 = q2;
        q2 = q;
    }

    // O(1)
    public int pop() throws Exception {
        return q1.dequeue();
    }

    public int size() {
        return q1.size();
    }

    public int top() throws Exception {
        return q1.getFront();
    }

    public void show() {
        q1.display();
    }
}

class test3 {
    public static void main(String[] args) throws Exception {
        StackUsingQueue_PopEfficient s = new StackUsingQueue_PopEfficient();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        s.show();

    }
}
