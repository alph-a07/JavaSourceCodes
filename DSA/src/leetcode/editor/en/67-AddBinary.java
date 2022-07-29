package leetcode.editor.en;// 2022-07-29 19:15:34

//leetcode submit region begin(Prohibit modification and deletion)
class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int an = 0;
            int bn = 0;

            // don't forget to convert to int
            if (i >= 0)
                an = a.charAt(i) - '0';
            if (j >= 0)
                bn = b.charAt(j) - '0';

            int tmp = an + bn + carry;

            res.insert(0, tmp % 2); // 💡
            carry = tmp / 2; // 💡
        }

        // last carry
        if (carry != 0)
            res.insert(0, carry);

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
