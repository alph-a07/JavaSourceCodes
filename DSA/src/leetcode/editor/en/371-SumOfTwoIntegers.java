// 2022-07-31 14:42:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution371 {
    public int getSum(int a, int b) {
        // we are storing sum in a and carry in b
        // run till carry becomes zero
        while (b != 0) {
            // carry = 1 only when both bits are 1 => Bitwise AND
            int carry = (a & b) << 1;
            // Sum = 0 only when both bits are 0 or 1 => Bitwise XOR
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
