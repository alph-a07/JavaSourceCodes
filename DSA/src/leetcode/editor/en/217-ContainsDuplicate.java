package leetcode.editor.en;// 2022-05-09 01:32:56

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
// T.C =  O(N)
// S.C =  O(N)
class ContainsDuplicateInArray {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return true;

            map.put(num, 1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
