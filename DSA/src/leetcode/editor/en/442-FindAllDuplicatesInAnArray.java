package leetcode.editor.en;// 2022-06-07 15:21:14

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution442 {

    // Concept: Negative marking
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();

        // To handle nth index
        // Loop is run from 1 to n
        // But array is traversed from 0 to n-1
        for (int i = 1; i <= nums.length; i++) {

            int next = Math.abs(nums[i - 1]);

            // mark negative if not already
            if (nums[next - 1] > 0)
                nums[next - 1] *= -1;
                // add to list if negative already
            else
                list.add(Math.abs(nums[i - 1]));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
