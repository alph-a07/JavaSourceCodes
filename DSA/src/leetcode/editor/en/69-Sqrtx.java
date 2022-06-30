package leetcode.editor.en;// 2022-05-09 01:28:06

//leetcode submit region begin(Prohibit modification and deletion)
class SquareRootProgramatically {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x)
                start = mid;
            else
                end = mid;
        }

        if (end * end == x)
            return (int) end;
        else
            return (int) start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
