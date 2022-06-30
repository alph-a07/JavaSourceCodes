package leetcode.editor.en;// 2022-05-09 01:07:54

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) throws Exception {

        int[] ans = new int[2];  // array to store answer

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int re = target - nums[i];

            // assume current element as one of the answer and check if other one exists
            if (map.containsKey(re))
                return new int[]{i, map.get(re)};

            map.put(nums[i], i); // if not put current element in map
        }
        throw new Exception("No sum found"); // if no sum found
    }
}
//leetcode submit region end(Prohibit modification and deletion)
