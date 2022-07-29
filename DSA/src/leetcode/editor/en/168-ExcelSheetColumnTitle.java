package leetcode.editor.en;// 2022-07-30 02:26:09

//leetcode submit region begin(Prohibit modification and deletion)
class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
