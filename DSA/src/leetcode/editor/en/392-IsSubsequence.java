package leetcode.editor.en;// 2022-07-06 18:49:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;

        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) // as relative order is same
                i++;
        }
        return i == s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
