package leetcode.editor.en;// 2022-07-30 18:14:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution7 {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int res = 0;

        // standard reversing process
        while (x != 0) {
            int digit = x % 10; // LSB
            x = x / 10;

            // before adding the last digit compare with max value
            if ((res > max / 10) || (res == max / 10 && digit >= max % 10)) return 0;

            // before adding the last digit compare with min value
            if ((res < min / 10) || (res == min / 10 && digit <= min % 10)) return 0;

            res = (res * 10) + digit; // reverse
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
