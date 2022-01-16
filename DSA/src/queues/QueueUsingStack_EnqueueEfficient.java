package queues;

import stacks.DynamicStack;

public class QueueUsingStack_EnqueueEfficient {

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

    // O(1)
    public void enqueue(int data) {
        s1.push(data);
    }

    // O(N)
    public int dequeue() {
        while (!(s1.size() == 1)) {
            s2.push(s1.pop());
        }
        int temp = s1.pop();
        while (!(s2.size() == 0)) {
            s1.push(s2.pop());
        }
        return temp;
    }

    // O(N)
    public int getFront() throws Exception {
        while (!(s1.size() == 1)) {
            s2.push(s1.pop());
        }
        int temp = s1.pop();
        s2.push(temp);
        DynamicStack s;
        s = s1;
        s1 = s2;
        s2 = s1;
        return temp;
    }

    // O(N)
    public void display() {
        s1.show();
    }
}

class test5 {
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
