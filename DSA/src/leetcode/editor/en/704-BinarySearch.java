package leetcode.editor.en;// 2022-07-12 18:40:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
