package leetcode.editor.en;// 2022-06-25 16:45:28

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        // queue can't be directly instantiated
        Queue<Integer> queue = new PriorityQueue<>(); // FIFO

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                queue.add(s.indexOf(entry.getKey())); // Add all unique characters to queue
        }

        return queue.isEmpty() ? -1 : queue.remove();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
