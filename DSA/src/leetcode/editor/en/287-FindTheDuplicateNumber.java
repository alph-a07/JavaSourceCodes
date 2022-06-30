package leetcode.editor.en;// 2022-06-05 16:39:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution287 {
    public int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
