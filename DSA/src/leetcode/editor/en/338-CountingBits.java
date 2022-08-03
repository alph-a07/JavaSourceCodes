package leetcode.editor.en;// 2022-07-31 13:48:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            // For even number -> Number of set bits = same as its half
            // For odd number -> Number of set bits = 1 more than its half
            res[i] = res[i >> 1] + (i & 1);
            // i >> 1 -> i/2
            // i & 1 -> i%2
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
