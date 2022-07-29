package leetcode.editor.en;// 2022-07-30 03:38:26

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2351 {
    public char repeatedCharacter(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                return c;
            }
            map.put(c, true);
        }
        return '\0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
