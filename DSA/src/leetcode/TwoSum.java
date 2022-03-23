package leetcode;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) throws Exception {

        int[] ans = new int[2];  // array to store answer

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // add all numbers with their indices to map
            // repeated numbers' indices will be updated to max possible index
        }

        for (int i = 0; i < nums.length; i++) {
            int re = target - nums[i];

            // assume current element as one of the answer and check if other one exists
            if (map.containsKey(re) && map.get(re) != i)
                return new int[]{i, map.get(re)};
        }
        throw new Exception("No sum found"); // if no sum found
    }
}
