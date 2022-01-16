package queues;

import stacks.DynamicStack;

public class QueueUsingStack_DequeueEfficient {
    private DynamicStack s1 = new DynamicStack(5);
    private DynamicStack s2 = new DynamicStack(5);

    // O(1)
    public int size() {
        return this.s1.size();
    }

    // O(1)
    public boolean isEmpty() {
        return this.s1.getTop() == 0;
    }

    // O(N)
    public void enqueue(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // O(1)
    public int dequeue() {
        return s1.pop();
    }

    // O(1)
    public int getFront() throws Exception {
        return s1.getTop();
    }

    // O(N)
    public void display() {
        s1.show();
    }
}

class test6 {
    public static void main(String[] args) throws Exception {
        QueueUsingStack_EnqueueEfficient q = new QueueUsingStack_EnqueueEfficient();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        q.display();

        System.out.println(q.dequeue());
        q.display();
        System.out.println(q.getFront());
    }
}
