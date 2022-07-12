package leetcode.editor.en;// 2022-07-12 16:00:28

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution409 {
    public int longestPalindrome(String s) {
        int maxLength = 0;
        boolean isOddAdded = false;
        HashMap<Character, Integer> map = new HashMap<>();

        // frequency map
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        for (Character c : map.keySet()) {
            // add even frequency
            if (map.get(c) % 2 == 0)
                maxLength += map.get(c);
            else {
                // add odd frequency just once to adjust center
                if (!isOddAdded) {
                    maxLength += map.get(c);
                    isOddAdded = true;
                }
                // add after making even afterwards
                else
                    maxLength += (map.get(c) - 1);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
