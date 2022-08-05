package leetcode.editor.en;// 2022-08-06 02:08:38

//leetcode submit region begin(Prohibit modification and deletion)
class Solution55 {

    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            // -ve base case
            if (i > maxReachable) return false;

            // max reach from any index is i + nums[i]
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
