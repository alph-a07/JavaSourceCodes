package leetcode.editor.en;// 2022-06-23 19:07:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1920 {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // % n is necessary for tackling updated values
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        // restoring original values (as nums[i] < n)
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
