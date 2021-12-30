package queues;

// Given an array and an integer K, find the maximum for each and every contiguous sub array of size k.

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfEveryWindowOfSizeK {

    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        fun(arr,3);
    }

    public static void fun(int[] arr, int k) {

        // (1) - Creating a deque and implementing it using LinkedList
        Deque<Integer> q = new LinkedList<>();
        int i;

        for (i = 0; i < k; i++) {

            // (3) - If current element is greater than the element at the index in deque then that element is useless
            while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                // (4) - Remove useless element index
                q.removeLast();
            }

            // (2) - Add all indices of current window to deque
            // The elements which are smaller than the greatest element but to the right of it will be added to deque
            // As there is a chance that they can be greatest for the next window
            q.addLast(i);
        }
        // --- First window is traversed till now (i = k)--- //

        for (; i <= arr.length - 1; i++) {

            // (5) - Printing the greatest element for previous window
            System.out.print(arr[q.getFirst()] + " ");

            // (6) - Removing the indices out of the current window
            while (!q.isEmpty() && q.getFirst() <= i - k){
                q.removeFirst();
            }

            // (7) - Repeating step(2)(3)(4) for current window
            while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);
        }
        // (8) - Printing max elements for further windows
        System.out.print(arr[q.getFirst()] + " ");
    }
}
