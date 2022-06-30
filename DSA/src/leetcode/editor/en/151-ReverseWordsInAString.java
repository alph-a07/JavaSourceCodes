package leetcode.editor.en;// 2022-06-14 15:28:12

//leetcode submit region begin(Prohibit modification and deletion)
class Solution151 {
    public String reverseWords(String s) {

        int i = s.length() - 1;
        int j = 0;
        String rev = "";

        while (s.charAt(i) == ' ') {
            i--;
        }
        j = i;

        while (s.charAt(i) != ' ') {
            j--;
        }

        return rev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
