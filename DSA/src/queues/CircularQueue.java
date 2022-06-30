package queues;

public class CircularQueue {
    public static int DEFAULT_CAPACITY = 5;
    int[] array;
    int front;
    int rear;
    int currentSize;
    int maxSize;

    CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    CircularQueue(int capacity) {
        this.array = new int[capacity];
        this.front = 0;
        this.currentSize = 0;
        this.rear = capacity - 1;
        this.maxSize = capacity;
    }

    public int getRear() {
        return this.array[this.rear];
    }

    // O(1)
    public boolean isFull() {
        return this.currentSize == this.maxSize;
    }

    // O(1)
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    // O(1)
    public void enqueue(int data) {
        if (!this.isFull()) {
            // modulo is used to implement circular array
            // i.e. if rear becomes more than max possible index then redirect it to the index 0
            this.rear = (this.rear + 1) % this.array.length;
            this.array[this.rear] = data;
            this.currentSize++;
        }
    }

    // O(1)
    public int dequeue() {
        int temp = this.array[this.front];
        if (!this.isEmpty()) {
            this.front = (this.front + 1) % this.array.length;
            this.currentSize--;
        }
        return temp;
    }

    // O(1)
    public int getFront() throws Exception {
        if (this.isEmpty()) throw new Exception("Empty Queue");
        return this.array[this.front];
    }

    // O(1)
    public int size() {
        return this.currentSize;
    }

    // O(N)
    public void display() {
        for (int i = 0; i < this.size(); i++) {
            int idx = (this.front + i) % this.array.length;
            System.out.print(this.array[idx] + " ");
        }
        System.out.println();
    }
}

class test {
    public static void main(String[] args) throws Exception {
        CircularQueue q = new CircularQueue(5);

        for (int i = 0; i < 5; i++) {
            q.enqueue(i + 1);
        }
        q.display();
        q.dequeue();
        q.dequeue();
        q.display();
        q.enqueue(99);
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(999);
        q.display();
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        System.out.println(q.isFull());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.isEmpty());
        q.display();
    }
}
