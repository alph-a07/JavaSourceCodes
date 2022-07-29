package leetcode.editor.en;// 2022-07-21 19:46:24

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }

        for (int j : nums) {
            int count = 1;

            // look for smaller consecutive numbers
            int num = j;
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look for greater consecutive numbers
            num = j;
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count); // result
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
