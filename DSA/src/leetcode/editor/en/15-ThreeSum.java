package leetcode.editor.en;// 2022-07-02 23:50:14

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        while ((nums.length % 2 == 0 && high - low >= 3) || (nums.length % 2 == 1 && high - low >= 2)) {
            int leftSum = 0;
            for (int i = low; i < low + 3; i++) {
                leftSum += nums[i];
            }
            if (leftSum == 0) {
                List<Integer> leftTemp = new ArrayList<>();
                for (int i = low; i < low + 3; i++) {
                    leftTemp.add(nums[i]);
                }
                ans.add(leftTemp);
            }
            low++;

            int rightSum = 0;
            for (int i = high; i > high - 3; i--) {
                rightSum += nums[i];
            }
            if (rightSum == 0) {
                List<Integer> rightTemp = new ArrayList<>();
                for (int i = high; i > high - 3; i--) {
                    rightTemp.add(nums[i]);
                }
                ans.add(rightTemp);
            }
            high--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
