package leetcode.editor.en;// 2022-05-09 01:22:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution26 {
    // IN-PLACE
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
