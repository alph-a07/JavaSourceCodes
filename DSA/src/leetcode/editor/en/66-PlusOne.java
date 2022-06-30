package leetcode.editor.en;// 2022-05-09 01:27:36

//leetcode submit region begin(Prohibit modification and deletion)
class LargeIntegerPlusOne {
    public int[] plusOne(int[] digits) {
        int counter = 0;
        // check for all 9
        for (int i : digits) {
            if (i == 9)
                counter++;
        }

        int[] arr; // answer array

        // all digits are 9
        if (counter == digits.length) {
            arr = new int[digits.length + 1]; // length += 1
            arr[0] = 1; // 9 + 1 = 10 ; 99 + 1 = 100

        }
        // not all digits are 9
        else {
            arr = digits;
            // last digit is not 9 -- no carry at all
            if (digits[digits.length - 1] != 9) {
                arr[digits.length - 1] += 1;
            }
            // some digits from right are 9 (consequent)
            else {
                arr[digits.length - 1] = 0; // 9 + 1 = 10
                int i;
                for (i = arr.length - 2; i >= 0 && arr[i] == 9; i--) {
                    arr[i] = 0; // answer digit = 0 for consequent 9s
                }
                arr[i] += 1; // add 1 carry to the first non-9 character
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
