package leetcode.editor.en;// 2022-05-09 01:34:33

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
// Time complexity = O(N)
// Space complexity = O(1) -- neglected ans list

class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // Loop on nums
        // Traverse and make all nums[i-1] negative for all nums[i]
        // So if nums[i] remains positive after loop, states that i is not present in the array
        for (int i = 0; i < nums.length; i++) {
            // absolute values to avoid repeated negation and invalid(-ve) indices
            int index = Math.abs(nums[i]);
            nums[index - 1] = -1 * Math.abs(nums[index - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
