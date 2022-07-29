package leetcode.editor.en;// 2022-07-15 19:11:44

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
