package leetcode.editor.en; // 2022-06-05 15:30:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // traverse from left
        for (int i = 0, temp = 1; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i]; // temp = product of elements on left of current element
        }
        // left product done for all

        // traverse from right
        for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
            result[i] *= temp; // left×right
            temp *= nums[i]; // temp = product of elements on right of current element
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
