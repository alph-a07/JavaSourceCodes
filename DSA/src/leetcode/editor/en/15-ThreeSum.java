package leetcode.editor.en;// 2022-07-02 23:50:14

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); // sort

        for (int i = 0; i < nums.length - 2; i++) {
            // a = nums[i] (only unique a)
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumSorted(i + 1, nums.length - 1, nums, -nums[i]);
            }
        }
        return res;
    }

    private void twoSumSorted(int start, int end, int[] nums, int target) {
        int a = nums[start - 1];

        // b + c = -a = target
        while (start < end) {
            int b = nums[start];
            int c = nums[end];

            // target exceeds - add larger number
            if (b + c < target) {
                start++;
            }
            // target lags - add smaller number
            else if (b + c > target) {
                end--;
            }
            // hit
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                temp.add(b);
                temp.add(c);

                res.add(temp);

                // skip duplicate b for current a
                while (start < end && nums[start] == nums[start + 1])
                    start++;

                // skip duplicate c for current a
                while (start < end && nums[end] == nums[end - 1])
                    end--;

                start++;
                end--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
