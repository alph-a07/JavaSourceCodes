package leetcode.editor.en;// 2022-06-23 19:01:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i < nums.length ? i : i % nums.length];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
