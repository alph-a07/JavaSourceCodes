package leetcode;

import java.util.HashMap;

// T.C =  O(N)
// S.C =  O(N)
public class ContainsDuplicateInArray {
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
