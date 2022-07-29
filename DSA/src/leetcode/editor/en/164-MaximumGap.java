package leetcode.editor.en;// 2022-07-22 15:51:22

//leetcode submit region begin(Prohibit modification and deletion)
class Solution164 {

    private static void countSort(int[] arr, int radix) {

        int[] count = new int[10]; //  0 - 9

        // counting
        for (int a : arr)
            count[(a / radix) % 10]++;

        // finding count of each element w.r.t elements before
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[arr.length];

        // inserting elements at their counted index
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--(count[(arr[i] / radix) % 10])] = arr[i];
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int a : nums)
            max = Math.max(a, max);

        int radix = 1;
        // count sort for each digit
        while (max / radix > 0) {
            countSort(nums, radix);
            radix *= 10;
        }

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }
        return maxDiff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
