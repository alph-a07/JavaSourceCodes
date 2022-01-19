package problems;

import queues.QueueUsingLinkedList;

public class FirstNegativeElementOfEveryWindowOfSizeK {
    public static void main(String[] args) throws Exception {

        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 29};
        fun(arr, 3);
    }

    // TIME COMPLEXITY - O(N)
    // Reason : All the indices are enqueued and dequeued once at-max => Hence total 2n times
    public static void fun(int[] array, int k) throws Exception {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        int i;
        // (1) For first window - storing indices of negative elements
        for (i = 0; i < k; i++) {
            if (array[i] < 0) {
                q.enqueue(i);
            }
        }

        // i = k
        for (; i < array.length; i++) {
            // (2) --- printing previous results ---
            if (!q.isEmpty()) {
                System.out.println(array[q.getFront()]);
            } else {
                // if no negative elements present
                System.out.println("0");
            }

            // (3) removing elements from previous window
            while (!q.isEmpty() && q.getFront() <= i - k) {
                q.dequeue();
            }

            // (4) adding negative elements as traverse forward
            if (array[i] < 0) {
                q.enqueue(i);
            }
        }

        // (5) --- printing results --- (For the last window)
        if (!q.isEmpty()) {
            System.out.println(array[q.getFront()]);
        } else {
            // if no negative elements present
            System.out.println("0");
        }
    }
}
