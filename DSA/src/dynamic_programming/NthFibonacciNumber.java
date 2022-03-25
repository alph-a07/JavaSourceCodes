package dynamic_programming;

public class NthFibonacciNumber {

    // T.C = O(2^n)
    // S.C = recursion space
    public static int recursive(int n) {

        // n = 0 -> fn = 0
        // n = 1 -> fn = 1
        if (n <= 1)
            return n;

        return recursive(n - 1) + recursive(n - 2); // fn = f(n-1) + f(n-2)
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(n) + recursion space    -- extra space for array
    // recursive approach
    public static int topDown(int n, int[] array) {

        // n = 0 -> fn = 0
        // n = 1 -> fn = 1
        if (n <= 1)
            return n;

        // Reuse stored values
        if (array[n] != 0)
            return array[n];

        int fn = topDown(n - 1, array) + topDown(n - 2, array); // fn = f(n-1) + f(n-2)
        array[n] = fn; // store values before returning for further use

        return fn;
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(n)    -- extra space for array (no recursion space)
    // iterative approach
    public static int bottomUp(int n) {

        // array of size n+1
        int[] array = new int[n + 1];

        // base case fill
        array[0] = 0;
        array[1] = 1;

        // array filling
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2]; // call meaning
        }

        return array[n];
    }

    // T.C = O(n)   -- each number calculated once only
    // S.C = O(1)   -- no extra space
    // iterative approach
    public static int bottomUpSpaceOptimized(int n) {

        int[] array = new int[2]; // array of size 2

        // base case fill
        array[0] = 0;
        array[1] = 1;

        for (int slide = 1; slide <= n - 1; slide++) {
            int sum = array[0] + array[1]; // get sum
            array[0] = array[1]; // move to next slide
            array[1] = sum; // sum at 2nd position
        }
        return array[1];
    }
}
