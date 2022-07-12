package leetcode.editor.en;// 2022-07-12 18:57:34

//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution278 extends VersionControl {
    int minBad = Integer.MAX_VALUE;

    public int firstBadVersion(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid - 1;
                minBad = Math.min(mid, minBad);
            } else {
                low = mid + 1;
            }
        }
        return minBad;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
