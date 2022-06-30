package leetcode.editor.en;// 2022-06-13 15:26:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int mid = 0;

        // binary search
        while (low < high) {
            mid = (low + high) / 2;

            if (letters[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        // low == high
        // go to next character if current character <= target
        // modulus for letters wrap
        if (target >= letters[high])
            return letters[(high + 1) % (letters.length)];
        else
            return letters[low];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
