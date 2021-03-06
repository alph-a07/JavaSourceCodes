package stacks;

import queues.QueueUsingLinkedList;

public class stackUsingQueue_PushEfficient {
    private QueueUsingLinkedList q1 = new QueueUsingLinkedList();
    private QueueUsingLinkedList q2 = new QueueUsingLinkedList();

    // O(1)
    public void push(int data) {
        this.q1.enqueue(data);
    }

    // O(N)
    public int pop() throws Exception {
        while (!(this.q1.size() == 1)) {
            q2.enqueue(q1.dequeue());
        }
        int temp = q1.dequeue();
        QueueUsingLinkedList q;
        q = q1;
        q1 = q2;
        q2 = q;
        return temp;
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

class test4 {
    public static void main(String[] args) throws Exception {
        StackUsingQueue_PopEfficient s = new StackUsingQueue_PopEfficient();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        System.out.println(s.pop());
        System.out.println();
        s.show();

    }
}


