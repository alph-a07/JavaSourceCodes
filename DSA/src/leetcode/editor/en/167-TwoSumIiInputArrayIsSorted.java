package leetcode.editor.en;// 2022-07-22 15:37:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high]; // curr sum

            // hit
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            }

            int mid = low + (high - low) / 2; // mid

            // sum exceeds
            if (sum > target) {
                // check if sum still exceeds for numbers[low] + numbers[mid]
                high = (numbers[low] + numbers[mid]) >= target ? mid : high - 1;
            }
            // sum lags
            else {
                // check if sum still lags for numbers[mid] + numbers[high]
                low = (numbers[mid] + numbers[high]) <= target ? mid : low + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
