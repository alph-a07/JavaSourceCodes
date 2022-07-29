package leetcode.editor.en;// 2022-07-30 03:07:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;

        int[] array = new int[2]; // array of size 2

        // base case fill
        array[0] = 0;
        array[1] = 1;

        for (int slide = 1; slide <= n - 1; slide++) {
            int sum = array[0] + array[1]; // get sum
            array[0] = array[1]; // move to next slide
            array[1] = sum; // sum at 2nd position
        }
        return array[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
