package leetcode.editor.en;// 2022-07-30 02:55:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res += Math.pow(26, columnTitle.length() - 1 - i) * (columnTitle.charAt(i) - 64);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
