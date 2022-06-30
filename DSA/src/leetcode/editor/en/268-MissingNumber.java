package leetcode.editor.en;// 2022-05-09 01:33:54

//leetcode submit region begin(Prohibit modification and deletion)
class MissingNumber {
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
//leetcode submit region end(Prohibit modification and deletion)
