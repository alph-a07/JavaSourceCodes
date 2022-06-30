package leetcode.editor.en;// 2022-05-09 01:24:24

//leetcode submit region begin(Prohibit modification and deletion)
class NeedleInHayStack {
    public int strStr(String haystack, String needle) {

        // empty string
        if (needle.length() == 0)
            return 0;

        int n = needle.length();
        // search for substring of needle length in haystack
        for (int i = 0; i <= haystack.length() - n; i++) {
            if (haystack.substring(i, i + n).equals(needle))
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
