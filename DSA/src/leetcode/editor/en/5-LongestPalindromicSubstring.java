package leetcode.editor.en;// 2022-07-30 16:54:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    public String longestPalindrome(String s) {

        // to keep track of the longest substring
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // ith element center for odd length substring
            int oddCenterLength = expand(s, i, i);
            // ith and (i+1)th elements center for even length string
            int evenCenterLength = expand(s, i, i + 1);

            int maxLength = Math.max(oddCenterLength, evenCenterLength); // max length pallindrome

            // update start and end
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        // expand till pallindrome is found
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
