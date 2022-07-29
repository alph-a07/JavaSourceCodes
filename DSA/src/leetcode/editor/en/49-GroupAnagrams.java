package leetcode.editor.en;// 2022-07-20 22:30:36

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s1 : strs) {
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);

            if (map.containsKey(str)) {
                map.get(str).add(s1);
            } else {
                map.put(str, new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
