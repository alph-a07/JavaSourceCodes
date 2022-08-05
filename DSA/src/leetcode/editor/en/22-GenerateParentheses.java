package leetcode.editor.en;// 2022-08-06 02:07:36

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, res, 0, 0, "");
        return res;
    }

    private void helper(int n, List<String> res, int open, int close, String s) {
        // base case
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        // open count should not exceed n
        if (open < n) {
            helper(n, res, open + 1, close, s + "(");
        }

        // close count should not exceed open count
        if (close < open) {
            helper(n, res, open, close + 1, s + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
