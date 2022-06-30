package leetcode.editor.en;// 2022-05-09 01:23:26

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveAllOccurrencesFromArray {
    // IN-PLACE
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        // Empty array
        if (nums.length == 0)
            return 0;

        // Traverse array from both ends
        // Aim : Gather all occurrences of val at the end
        while (low >= 0 && high <= nums.length - 1 && low < high) {

            // If val is already low, move left
            while (high >= low && nums[high] == val)
                high--;

            // If val is not at high, move right
            if (nums[low] != val)
                low++;

                // val is at start, swap with non-val high
            else {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }

        int counter = 0; //
        for (int i = nums.length - 1; i >= 0 && nums[i] == val; i--) {
            counter++; // number of val occurrences at end
        }
        return nums.length - counter; // effective number of elements
    }
}
//leetcode submit region end(Prohibit modification and deletion)
