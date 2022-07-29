package leetcode.editor.en;// 2022-07-16 16:04:40

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length())
            return ans;

        HashMap<Character, Integer> pMap = new HashMap<>(); // frequency map for p
        HashMap<Character, Integer> sMap = new HashMap<>(); // sliding map for s

        for (int i = 0; i < p.length(); i++) {
            // p's frequency map
            if (pMap.containsKey(p.charAt(i)))
                pMap.put(p.charAt(i), pMap.get(p.charAt(i)) + 1);
            else
                pMap.put(p.charAt(i), 1);

            // first window of s
            if (sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            else
                sMap.put(s.charAt(i), 1);
        }

        // traversing s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // +ve hit
            if (pMap.equals(sMap))
                ans.add(i);

            // removing 1st character of window to move window
            if (sMap.get(s.charAt(i)) == 1)
                sMap.remove(s.charAt(i));
            else
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);

            // adding last character of window to slide window
            if (i != s.length() - p.length()) {
                char c = s.charAt(i + p.length());
                if (sMap.containsKey(c))
                    sMap.put(c, sMap.get(c) + 1);
                else
                    sMap.put(c, 1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
