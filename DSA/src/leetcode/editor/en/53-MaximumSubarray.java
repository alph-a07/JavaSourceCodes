package leetcode.editor.en;// 2022-06-13 14:28:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution378 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
