package dynamic_programming;

public class FrogJump {
    public static int frogJump(int n, int[] heights) {
        // 1 -> n stairs ==> 0 to n-1 array
        int[] storage = new int[n]; // storage -> filling from 1 to n-1
        // storage[i] = minimum energy required to reach ith stair from 0th stair

        // base case storage[0] = 0
        int i = 1;
        while (i < n) {
            // one-step energy
            int step1 = i - 1 >= 0 ? storage[i - 1] + Math.abs(heights[i] - heights[i - 1]) : Integer.MAX_VALUE;

            // two steps energy
            int step2 = i - 2 >= 0 ? storage[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;

            storage[i] = Math.min(step1, step2); // store minimum energy
            i++;
        }
        return storage[n - 1];
    }
}
