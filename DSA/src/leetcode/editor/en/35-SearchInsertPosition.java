package leetcode.editor.en;// 2022-05-09 01:26:24

//leetcode submit region begin(Prohibit modification and deletion)
class InsertionInSortedArray {
    // Binary search
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else return mid;
        }
        return high + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
