package leetcode.editor.en;// 2022-07-02 22:22:34

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution525 {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 1)
            return 0;

        int currSum = 0;
        int maxLength = 0;

        // key: sum till current index
        // value: current index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // starting from nothing (index = -1)

        // converting 0s to -1s
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            // 💡: Suppose sum till index = 0 to x is same as sum till index = o to i
            // 💡: Then the sum in between x and i must be 0 and that's a hit
            if (map.containsKey(currSum)) {
                maxLength = Math.max(maxLength, i - map.get(currSum)); // update maxLength
            } else
                map.put(currSum, i); // store sum
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
