package dynamic_programming;

public class NthFibonacciNumber {

    // T.C = O(2^n)
    // S.C = recursion space
    // stack overflow for very large values of n
    public static int recursive(int n) {
        // base case
        if (n <= 1)
            return n;

        return recursive(n - 1) + recursive(n - 2); // smaller problems
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(n) + recursion space
    // recursive memorisation
    public static int topDown(int n, int[] storage) {

        // base case
        if (n <= 1) {
            storage[n] = n; // store before return
            return storage[n];
        }

        // check in storage before recursive call
        int x = storage[n - 1] != 0 ? storage[n - 1] : topDown(n - 1, storage);
        int y = storage[n - 2] != 0 ? storage[n - 2] : topDown(n - 2, storage);

        storage[n] = x + y; // store before return

        return storage[n];
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(n)    -- extra space for array (no recursion space)
    // iterative memorisation
    public static int bottomUp(int n) {
        // edge case
        if (n == 0)
            return 0;

        int[] storage = new int[n + 1]; // 0 -> n

        // base case
        storage[1] = 1;

        // storage filling
        for (int i = 2; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2]; // call meaning
        }

        return storage[n];
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(1)
    // iterative memorisation with constant space
    public static int bottomUpSpaceOptimized(int n) {

        // edge case
        if (n == 0)
            return 0;

        int[] storage = new int[2]; // 0 -> n

        // starting window
        storage[0] = 0;
        storage[1] = 1;

        // storage filling
        for (int i = 2; i <= n; i++) {
            int sum = storage[0] + storage[1]; // next number
            storage[0] = storage[1]; // shift left
            storage[1] = sum; // next number
        }

        return storage[1];
    }
}
