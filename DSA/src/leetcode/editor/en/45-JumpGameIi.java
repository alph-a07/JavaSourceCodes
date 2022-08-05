// 2022-08-06 02:48:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int jump(int[] nums) {
        int jumps = 0, curr_end = 0, max_reach = 0;
        // curr_end -> max jump possible from last index where we stayed
        // max_reach -> max jump possible from ith index

        // note excluded last index
        // also i != stayed index
        for (int i = 0; i < nums.length - 1; i++) {
            max_reach = Math.max(max_reach, i + nums[i]); // update max reach

            // if we encounter curr_end then it's time to jump from last stayed index to ith index
            if (i == curr_end) {
                jumps++;
                curr_end = max_reach; // because current stay = i
            }
        }
        return jumps;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
