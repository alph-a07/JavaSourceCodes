package leetcode.editor.en;// 2022-07-16 16:03:44

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            // if unique elements are coming, increase max
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
            // only unique elements are added to set
            // hence first of current window is the same one only
            // remove it
            else {
                set.remove(s.charAt(i));
                i++; // i keeps track of head of the window
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
