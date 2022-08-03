package leetcode.editor.en;// 2022-07-30 03:07:02

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0)
                res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
