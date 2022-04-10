package dynamic_programming;

// Given a position on a board, find number of ways to reach there linearly by throwing a die.
public class BoardPath {
    public static void main(String[] args) {
        //System.out.println(topdown(0, 10000, new int[10000]));
        System.out.println(bottomUp(100000));
        System.out.println(bottomUpSE(100000));
    }

    // Time complexity = O(6^n)
    // Space complexity = O(1) + R.S
    public static int recursive(int current, int end) {

        // positive base case
        if (current == end)
            return 1;

        // negative base case
        if (current > end)
            return 0;

        int count = 0;

        for (int die = 1; die <= 6; die++) {
            count += recursive(current + die, end); // call meaning
        }

        return count;
    }

    // Time complexity = O(n)
    // Space complexity = O(n) + R.S
    public static int topdown(int current, int end, int[] storage) {
        // positive base case
        if (current == end)
            return 1;

        // negative base case
        if (current > end)
            return 0;

        // reuse
        if (storage[current] != 0)
            return storage[current];

        int count = 0;

        for (int die = 1; die <= 6; die++) {
            count += topdown(current + die, end, storage); // call meaning
        }

        storage[current] = count; // store
        return count;
    }

    // Time complexity = O(n)
    // Space complexity = O(n)
    public static int bottomUp(int end) {

        int[] storage = new int[end + 6];

        storage[end] = 1; // positive base case (other will be 0 by default -- negative base case)

        for (int i = end - 1; i >= 0; i--) {
            storage[i] = storage[i + 1] + storage[i + 2] + storage[i + 3] + storage[i + 4] + storage[i + 5] + storage[i + 6];
        }
        return storage[0];
    }

    // Time complexity = O(n)
    // Space complexity = O(1)
    public static int bottomUpSE(int end) {
        int[] storage = new int[6];

        storage[0] = 1;

        for (int slide = 1; slide <= end; slide++) {
            int sum = 0;

            for (int i : storage)
                sum += i;
            for (int i = 5; i > 0; i--) {
                storage[i] = storage[i - 1];
            }
            storage[0] = sum;
        }

        return storage[0];
    }
}
