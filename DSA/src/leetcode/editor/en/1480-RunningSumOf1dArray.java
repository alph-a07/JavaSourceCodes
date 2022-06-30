package leetcode.editor.en;// 2022-06-23 19:32:34

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1480 {
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
