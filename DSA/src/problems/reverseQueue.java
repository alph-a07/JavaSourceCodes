package problems;

import queues.QueueUsingLinkedList;

// Same approach as reversing stack
public class reverseQueue {
    public static void main(String[] args) throws Exception {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.display();
        System.out.println("----------------------------");
        reverseQueue(q);
        q.display();
    }

    public static void reverseQueue(QueueUsingLinkedList queue) throws Exception {
        if(queue.isEmpty())
            return;
        int temp = queue.dequeue();
        reverseQueue(queue);
        queue.enqueue(temp);
    }
}
