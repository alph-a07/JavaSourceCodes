package leetcode.editor.en;// 2022-08-03 01:50:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1); // reverse whole array
        reverse(nums, 0, k - 1); // reverse 0 to k-1
        reverse(nums, k, nums.length - 1); // reverse k to length-1
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
