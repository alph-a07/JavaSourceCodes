package leetcode.editor.en;// 2022-06-09 14:59:40

//leetcode submit region begin(Prohibit modification and deletion)
class Solution75 {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Just arrange 0s and 2s, 1s will be arranged by itself
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, i = 0;
        while (i <= high) {
            // If 0, swao with low
            if (nums[i] == 0) {
                swap(nums, low, i);
                i++;
                low++;
            } else if (nums[i] == 1) {
                i++;
            }
            // no need to increase i as high is decreased and while loop will be iterating over high
            // If 2, swap with high
            else {
                swap(nums, i, high);
                high--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
