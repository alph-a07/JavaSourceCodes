package leetcode;

public class MissingNumber {
    // Time complexity = O(N)
    // Space complexity = O(1)
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2; // sum of 1 to n

        // Traverse array and subtract each term from sum
        for (int num : nums) {
            sum = sum - num;
        }
        return sum; // sum = missing element
    }
}


