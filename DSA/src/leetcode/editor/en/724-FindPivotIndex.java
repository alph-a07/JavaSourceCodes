package leetcode.editor.en;// 2022-07-05 21:49:25

//leetcode submit region begin(Prohibit modification and deletion)
class Solution724 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;

        // sum of whole array
        for (int num : nums)
            rightSum += num;

        // starting from left
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; // subtract from right sum

            if (rightSum == leftSum)
                return i;

            leftSum += nums[i]; // add to left sum
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
