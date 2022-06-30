package leetcode.editor.en;// 2022-06-14 15:08:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution344 {
    public void reverseString(char[] s) {

        int low = 0;
        int high = s.length - 1;

        // swap low and high
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
