package leetcode.editor.en;// 2022-06-08 15:01:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution136 {
    static int singleNumber(int[] arr) {
        int res = 0;

        for (int a : arr) {
            res ^= a; // duplicate numbers will be converted to 0 after XOR and a ^ 0 = a
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
