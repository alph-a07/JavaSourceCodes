package leetcode.editor.en;// 2022-07-30 03:07:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {
    public int fib(int n) {
        // edge case
        if (n == 0)
            return 0;

        int[] storage = new int[2]; // 0 -> n

        // starting window
        storage[0] = 0;
        storage[1] = 1;

        // storage filling
        for (int i = 2; i <= n; i++) {
            int sum = storage[0] + storage[1]; // next number
            storage[0] = storage[1]; // shift left
            storage[1] = sum; // next number
        }

        return storage[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
